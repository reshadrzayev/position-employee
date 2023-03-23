package com.example.positionemployee.controller;

import com.example.positionemployee.dto.EmployeeDto;
import com.example.positionemployee.dto.EmployeePagination;
import com.example.positionemployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public EmployeeDto getByName(@RequestParam String phoneNumber) {
        return service.getByPhoneNumber(phoneNumber);
    }

    @PostMapping
    public void savePosition(@RequestBody EmployeeDto dto) {
        service.saveEmployee(dto);
    }

    @PutMapping("/update/{id}")
    public void updatePosition(@RequestBody EmployeeDto dto, @PathVariable Long id) {
        service.updateEmployee(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deletPositoinById(@PathVariable Long id) {
        service.deleteEmployeeById(id);
    }

    @GetMapping("/sort")
    public List<EmployeeDto> sortPosition(@RequestParam String name, @RequestParam String sorting) {
        return service.sortingEmployee(name, sorting);
    }

    @GetMapping("/page")
    public EmployeePagination positionPagination(@RequestParam Integer page, @RequestParam Integer count) {
        return service.pagination(page, count);
    }
}
