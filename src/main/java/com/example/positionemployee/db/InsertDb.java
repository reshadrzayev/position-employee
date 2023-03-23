package com.example.positionemployee.db;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
@Configuration
public class InsertDb {
    private final JdbcTemplate jdbcTemplate;

    @Bean
    CommandLineRunner loadDatabase( ) {
        return args -> {
            //insert poitions
            jdbcTemplate.execute("INSERT INTO positions (name, salary)\n" +
                                         "VALUES ( 'Junior Developer',1600)");

            jdbcTemplate.execute("INSERT INTO positions (name, salary)\n" +
                                         "VALUES ( 'Middle Developer',2300)");

            jdbcTemplate.execute("INSERT INTO positions (name, salary)\n" +
                                         "VALUES ( 'Senior Developer',3000)");

//            insert employee
            jdbcTemplate.execute(
                    "INSERT INTO employee (first_name, last_name, phone_number, started_year, gender, position_id)\n" +
                            "VALUES ( 'Rahib', 'Hamidov','+994501234567','2022-10-20','MALE',1)");

            jdbcTemplate.execute(
                    "INSERT INTO employee (first_name, last_name, phone_number, started_year, gender, position_id)\n" +
                            "VALUES ( 'Arzu', 'Malikova','+994701234567','2020-01-01','FEMALE',2)");

            jdbcTemplate.execute(
                    "INSERT INTO employee (first_name, last_name, phone_number, started_year, gender, position_id)\n" +
                            "VALUES ( 'Resad', 'Hesenov','+994771234567','2015-01-01','MALE',3)");
        };
    }

}
