package com.example.qabul.repository;

import com.example.qabul.entity.StudyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyTypeRepository extends JpaRepository<StudyType,Integer> {

    Optional<StudyType> findByIdAndDeletedAtIsNull(Integer id);
}
