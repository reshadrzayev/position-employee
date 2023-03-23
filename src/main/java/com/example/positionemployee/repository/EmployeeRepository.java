package com.example.positionemployee.repository;

import com.example.positionemployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.id =:id")
    Optional<Employee> getEmployeeById(Long id);

    Employee findByPhoneNumber(String phoneNumber);
}
