package com.example.positionemployee.mapper;

import com.example.positionemployee.dto.EmployeeDto;
import com.example.positionemployee.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMap {

    public EmployeeDto entityToDto(Employee employee) {
        return EmployeeDto.builder()
                          .firstName(employee.getFirstName())
                          .lastName(employee.getLastName())
                          .phoneNumber(employee.getPhoneNumber())
                          .startedYear(employee.getStartedYear())
                          .gender(employee.getGender())
                          .build();
    }

    public Employee dtoToEntity(EmployeeDto dto) {
        return Employee.builder()
                       .firstName(dto.getFirstName())
                       .lastName(dto.getLastName())
                       .phoneNumber(dto.getPhoneNumber())
                       .startedYear(dto.getStartedYear())
                       .gender(dto.getGender())
                       .build();
    }
}
