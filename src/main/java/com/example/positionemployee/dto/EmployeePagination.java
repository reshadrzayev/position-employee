package com.example.positionemployee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class EmployeePagination {
    private List<EmployeeDto> employeeDtos;
    private int lastPage;
    private boolean hasNext;
}
