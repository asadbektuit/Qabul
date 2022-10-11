package com.example.qabul.repository;

import com.example.qabul.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image ,Integer> {
    Optional<Image> findByToken(String token);
}
