package com.example.positionemployee.entity;

import com.example.positionemployee.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate startedYear;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;
}
