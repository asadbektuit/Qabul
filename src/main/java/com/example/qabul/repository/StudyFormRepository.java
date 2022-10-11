package com.example.qabul.repository;

import com.example.qabul.entity.StudyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudyFormRepository extends JpaRepository<StudyForm,Integer> {


    Optional<StudyForm> findByIdAndDeletedAtIsNull(Integer id);
}
