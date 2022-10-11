package com.example.qabul.repository;

import com.example.qabul.entity.UniversityName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UniversityNameRepository extends JpaRepository<UniversityName,Integer> {


    Optional<UniversityName> findByIdAndDeletedAtIsNull(Integer id);
}
