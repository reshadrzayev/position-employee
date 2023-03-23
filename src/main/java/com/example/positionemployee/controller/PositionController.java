package com.example.positionemployee.controller;

import com.example.positionemployee.dto.PositionDto;
import com.example.positionemployee.dto.PositionPagination;
import com.example.positionemployee.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/position")
@RestController
@RequiredArgsConstructor
public class PositionController {
    private final PositionService service;

    @GetMapping("/{id}")
    public PositionDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public PositionDto getByName(@RequestParam String name) {
        return service.getByName(name);
    }

    @PostMapping
    public void savePosition(@RequestBody PositionDto dto) {
        service.savePosition(dto);
    }

    @PutMapping("/update/{id}")
    public void updatePosition(@RequestBody PositionDto dto, @PathVariable Long id) {
        service.updatePosition(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deletPositoinById(@PathVariable Long id) {
        service.deletePositionById(id);
    }

    @GetMapping("/sort")
    public List<PositionDto> sortPosition(@RequestParam String name, @RequestParam String sorting) {
        return service.sortingPosition(name, sorting);
    }

    @GetMapping("/page")
    public PositionPagination positionPagination(@RequestParam Integer page, @RequestParam Integer count) {
        return service.pagination(page, count);
    }
}
