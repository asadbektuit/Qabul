package com.example.qabul.service;

import com.example.qabul.dto.DegreeDto;
import com.example.qabul.dto.RetrainingCourseDto;
import com.example.qabul.entity.Degree;
import com.example.qabul.entity.RetrainingCourse;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.DegreeRepository;
import com.example.qabul.repository.RetrainingCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RetrainingCourseService {
    @Autowired
    private RetrainingCourseRepository retrainingCourseRepository;

    public RetrainingCourseDto get(Integer id) {
        RetrainingCourse retrainingCourse = getEntity(id);
        RetrainingCourseDto dto = new RetrainingCourseDto();
        dto.setName(retrainingCourse.getName());;
        return dto;
    }
    public RetrainingCourseDto create(RetrainingCourseDto dto) {
        RetrainingCourse retrainingCourse = new RetrainingCourse();
        retrainingCourse.setName(dto.getName());
        retrainingCourse.setCreatedAt(LocalDateTime.now());
        retrainingCourseRepository.save(retrainingCourse);
        return dto;
    }
    public boolean update(Integer id, RetrainingCourseDto dto) {
        RetrainingCourse retrainingCourse = getEntity(id);
        retrainingCourse.setName(dto.getName());
        retrainingCourse.setUpdatedAt(LocalDateTime.now());
        retrainingCourseRepository.save(retrainingCourse);
        return true;
    }
    public boolean delete(Integer id) {
        RetrainingCourse retrainingCourse = getEntity(id);
        retrainingCourse.setDeletedAt(LocalDateTime.now());
        retrainingCourseRepository.save(retrainingCourse);
        return true;
    }
    private RetrainingCourse getEntity(Integer id) {
        Optional<RetrainingCourse> optional = retrainingCourseRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("RetrainingCourse not found");
        }
        return optional.get();
    }
}
