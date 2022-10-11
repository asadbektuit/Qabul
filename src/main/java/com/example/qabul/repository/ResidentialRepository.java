package com.example.qabul.repository;

import com.example.qabul.entity.Degree;
import com.example.qabul.entity.Residential;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ResidentialRepository extends JpaRepository<Residential, Integer> {

    Optional<Residential> findByIdAndDeletedAtIsNull(Integer id);
}
