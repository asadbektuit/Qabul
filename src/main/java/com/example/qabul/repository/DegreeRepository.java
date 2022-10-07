package com.example.qabul.repository;

import com.example.qabul.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DegreeRepository extends JpaRepository<Degree,Integer> {

    Optional<Degree> findByIdAndDeletedAtIsNull(Integer id);
}
