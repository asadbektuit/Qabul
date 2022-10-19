package com.example.qabul.service;

import com.example.qabul.dto.DegreeDto;
import com.example.qabul.dto.SportTypeDto;
import com.example.qabul.dto.StudyTypeDto;
import com.example.qabul.entity.Degree;
import com.example.qabul.entity.StudyType;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.DegreeRepository;
import com.example.qabul.repository.StudyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudyTypeService {

    @Autowired
    private StudyTypeRepository studyTypeRepository;

    public StudyTypeDto get(Integer id) {
        StudyType studyType = getEntity(id);
        StudyTypeDto dto = new StudyTypeDto();
        dto.setName(studyType.getName());;
        return dto;
    }
    public StudyTypeDto create(StudyTypeDto dto) {
        StudyType studyType = new StudyType();
        studyType.setName(dto.getName());
        studyType.setCreatedAt(LocalDateTime.now());
        studyTypeRepository.save(studyType);
        return dto;
    }
    public boolean update(Integer id, StudyTypeDto dto) {
        StudyType studyType = getEntity(id);
        studyType.setName(dto.getName());
        studyType.setUpdatedAt(LocalDateTime.now());
        studyTypeRepository.save(studyType);
        return true;
    }
    public boolean delete(Integer id) {
        StudyType studyType = getEntity(id);
        studyType.setDeletedAt(LocalDateTime.now());
        studyTypeRepository.save(studyType);
        return true;
    }
    public StudyType getEntity(Integer id) {
        Optional<StudyType> optional = studyTypeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("Study type not found");
        }
        return optional.get();
    }
}
