package com.example.positionemployee.mapper;

import com.example.positionemployee.dto.PositionDto;
import com.example.positionemployee.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Component
public class PositionMap {

    public Position dtoToEntity(PositionDto dto) {
        return Position.builder()
                       .name(dto.getName())
                       .salary(dto.getSalary())
                       .build();
    }


    public PositionDto entityToDto(Position entity) {
        return PositionDto.builder()
                          .name(entity.getName())
                          .salary(entity.getSalary())
                          .build();
    }
}
