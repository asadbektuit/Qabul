package com.example.qabul.repository;

import com.example.qabul.entity.StudyPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudyPlaceRepository extends JpaRepository<StudyPlace,Integer> {

    Optional<StudyPlace> findByIdAndDeletedAtIsNull(Integer id);
}
