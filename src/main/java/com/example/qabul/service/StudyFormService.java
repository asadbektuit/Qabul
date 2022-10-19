package com.example.qabul.service;

import com.example.qabul.dto.DegreeDto;
import com.example.qabul.dto.StudyFormDto;
import com.example.qabul.entity.Degree;
import com.example.qabul.entity.StudyForm;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.DegreeRepository;
import com.example.qabul.repository.StudyFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudyFormService {
    @Autowired
    private StudyFormRepository studyFormRepository;

    public StudyFormDto get(Integer id) {
        StudyForm studyForm = getEntity(id);
        StudyFormDto dto = new StudyFormDto();
        dto.setName(studyForm.getName());;
        return dto;
    }
    public StudyFormDto create(StudyFormDto dto) {
        StudyForm studyForm = new StudyForm();
        studyForm.setName(dto.getName());
        studyForm.setCreatedAt(LocalDateTime.now());
        studyFormRepository.save(studyForm);
        return dto;
    }
    public boolean update(Integer id, StudyFormDto dto) {
        StudyForm studyForm = getEntity(id);
        studyForm.setName(dto.getName());
        studyForm.setUpdatedAt(LocalDateTime.now());
        studyFormRepository.save(studyForm);
        return true;
    }
    public boolean delete(Integer id) {
        StudyForm studyForm = getEntity(id);
        studyForm.setDeletedAt(LocalDateTime.now());
        studyFormRepository.save(studyForm);
        return true;
    }
    public StudyForm getEntity(Integer id) {
        Optional<StudyForm> optional = studyFormRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("StudyForm not found");
        }
        return optional.get();
    }
}
