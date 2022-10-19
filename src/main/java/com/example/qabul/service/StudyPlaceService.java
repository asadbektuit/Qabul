package com.example.qabul.service;

import com.example.qabul.dto.DegreeDto;
import com.example.qabul.dto.StudyPlaceDto;
import com.example.qabul.entity.Degree;
import com.example.qabul.entity.StudyPlace;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.DegreeRepository;
import com.example.qabul.repository.StudyPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudyPlaceService {
    @Autowired
    private StudyPlaceRepository studyPlaceRepository;

    public StudyPlaceDto get(Integer id) {
        StudyPlace studyPlace = getEntity(id);
        StudyPlaceDto dto = new StudyPlaceDto();
        dto.setName(studyPlace.getName());;
        return dto;
    }
    public StudyPlaceDto create(StudyPlaceDto dto) {
        StudyPlace studyPlace = new StudyPlace();
        studyPlace.setId(dto.getId());
        studyPlace.setName(dto.getName());
        studyPlace.setCreatedAt(LocalDateTime.now());
        studyPlaceRepository.save(studyPlace);
        return dto;
    }
    public boolean update(Integer id, StudyPlaceDto dto) {
        StudyPlace studyPlace = getEntity(id);
        studyPlace.setName(dto.getName());
        studyPlace.setUpdatedAt(LocalDateTime.now());
        studyPlaceRepository.save(studyPlace);
        return true;
    }
    public boolean delete(Integer id) {
        StudyPlace studyPlace = getEntity(id);
        studyPlace.setDeletedAt(LocalDateTime.now());
        studyPlaceRepository.save(studyPlace);
        return true;
    }
    public StudyPlace getEntity(Integer id) {
        Optional<StudyPlace> optional = studyPlaceRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("StudyPlace not found");
        }
        return optional.get();
    }
}
