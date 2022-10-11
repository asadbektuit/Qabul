package com.example.qabul.repository;

import com.example.qabul.entity.Degree;
import com.example.qabul.entity.RetrainingCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RetrainingCourseRepository extends JpaRepository<RetrainingCourse, Integer> {

    Optional<RetrainingCourse> findByIdAndDeletedAtIsNull(Integer id);
}
