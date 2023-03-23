package com.example.positionemployee.repository;

import com.example.positionemployee.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position,Long> {

    @Query("select p from Position p where p.id =:id")
    Optional<Position> getPositionById(Long id);

    Position findByName(String name);
}
