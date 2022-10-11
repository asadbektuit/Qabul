package com.example.qabul.repository;

import com.example.qabul.entity.Degree;
import com.example.qabul.entity.EducationLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EducationLanguageRepository extends JpaRepository<EducationLanguage, Integer> {

    Optional<EducationLanguage> findByIdAndDeletedAtIsNull(Integer id);
}
