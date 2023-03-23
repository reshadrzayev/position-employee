package com.example.positionemployee.service;

import com.example.positionemployee.dto.PositionDto;
import com.example.positionemployee.dto.PositionPagination;
import com.example.positionemployee.entity.Position;
import com.example.positionemployee.exception.NotFound;
import com.example.positionemployee.mapper.PositionMap;
import com.example.positionemployee.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository repository;
    private final PositionMap map;

    public PositionDto getById(Long id) {
        Position position = repository.getPositionById(id)
                                      .orElseThrow(( ) -> new NotFound("Position not found", "POSITION_NOT_FOUND"));
        return map.entityToDto(position);
    }

    public PositionDto getByName(String name) {
        Position position = repository.findByName(name);
        return map.entityToDto(position);
    }

    public void savePosition(PositionDto dto) {
        Position entity = map.dtoToEntity(dto);
        repository.save(entity);
    }

    public void updatePosition(PositionDto dto, Long id) {
        Position position = repository.getPositionById(id)
                                      .orElseThrow(( ) -> new NotFound("Position not found", "POSITION_NOT_FOUND"));

        if (dto.getName() != null) position.setName(dto.getName());
        if (dto.getSalary() != null) position.setSalary(dto.getSalary());

        repository.save(position);
    }

    public void deletePositionById(Long id) {
        repository.deleteById(id);
    }

    public PositionPagination pagination(Integer page, Integer count) {
        var pageRequest = PageRequest.of(page, count);
        var positions = repository.findAll(pageRequest);
        return PositionPagination.builder()
                                 .positions(positions.getContent().stream().map(map::entityToDto)
                                                     .collect(Collectors.toList()))
                                 .lastPage(positions.getTotalPages())
                                 .hasNext(positions.hasNext())
                                 .build();
    }

    public List<PositionDto> sortingPosition(String name, String sorting) {
        List<Position> entity;
        var type = sorting.toUpperCase();
        if (type.equals("DESC")) entity = repository.findAll(
                Sort.by(Sort.Direction.DESC, name));
        else entity = repository.findAll(Sort.by(Sort.Direction.ASC, name));
        return entity.stream().map(map::entityToDto).collect(Collectors.toList());
    }
}
