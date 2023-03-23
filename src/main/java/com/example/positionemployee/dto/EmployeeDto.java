package com.example.positionemployee.dto;

import com.example.positionemployee.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate startedYear;
    private Gender gender;
}
