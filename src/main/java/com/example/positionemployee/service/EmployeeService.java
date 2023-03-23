package com.example.positionemployee.service;

import com.example.positionemployee.dto.EmployeeDto;
import com.example.positionemployee.dto.EmployeePagination;
import com.example.positionemployee.entity.Employee;
import com.example.positionemployee.exception.NotFound;
import com.example.positionemployee.mapper.EmployeeMap;
import com.example.positionemployee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMap map;


    public EmployeeDto getById(Long id) {
        Employee employee = repository.getEmployeeById(id)
                                      .orElseThrow(( ) -> new NotFound("Employee not found", "EMPLOYEE_NOT_FOUND"));
        return map.entityToDto(employee);
    }

    public EmployeeDto getByPhoneNumber(String phoneNumber) {
        Employee employee = repository.findByPhoneNumber(phoneNumber);
        return map.entityToDto(employee);
    }

    public void saveEmployee(EmployeeDto dto) {
        Employee entity = map.dtoToEntity(dto);
        repository.save(entity);
    }

    public void updateEmployee(EmployeeDto dto, Long id) {
        Employee employee = repository.getEmployeeById(id)
                                      .orElseThrow(( ) -> new NotFound("Employee not found", "EMPLOYEE_NOT_FOUND"));

        if (dto.getLastName() != null) employee.setLastName(dto.getLastName());
        if (dto.getFirstName() != null) employee.setFirstName(dto.getFirstName());
        if (dto.getGender() != null) employee.setGender(dto.getGender());
        if (dto.getStartedYear() != null) employee.setStartedYear(dto.getStartedYear());
        if (dto.getPhoneNumber() != null) employee.setPhoneNumber(dto.getPhoneNumber());

        repository.save(employee);
    }

    public void deleteEmployeeById(Long id) {
        repository.deleteById(id);
    }

    public EmployeePagination pagination(Integer page, Integer count) {
        var pageRequest = PageRequest.of(page, count);
        var employees = repository.findAll(pageRequest);
        return EmployeePagination.builder()
                                 .employeeDtos(employees.getContent().stream().map(map::entityToDto)
                                                        .collect(Collectors.toList()))
                                 .lastPage(employees.getTotalPages())
                                 .hasNext(employees.hasNext())
                                 .build();
    }

    public List<EmployeeDto> sortingEmployee(String name, String sorting) {
        List<Employee> entity;
        var type = sorting.toUpperCase();
        if (type.equals("DESC")) entity = repository.findAll(
                Sort.by(Sort.Direction.DESC, name));
        else entity = repository.findAll(Sort.by(Sort.Direction.ASC, name));
        return entity.stream().map(map::entityToDto).collect(Collectors.toList());
    }
}
