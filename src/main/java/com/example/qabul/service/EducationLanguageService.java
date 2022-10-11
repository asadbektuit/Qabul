package com.example.qabul.service;

import com.example.qabul.dto.EducationLanguageDto;
import com.example.qabul.entity.EducationLanguage;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.EducationLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EducationLanguageService {
    @Autowired
    private EducationLanguageRepository educationLanguageRepository;

    public EducationLanguageDto get(Integer id) {
        EducationLanguage educationLanguage = getEntity(id);
        EducationLanguageDto dto = new EducationLanguageDto();
        dto.setName(educationLanguage.getName());;
        return dto;
    }
    public EducationLanguageDto create(EducationLanguageDto dto) {
        EducationLanguage educationLanguage = new EducationLanguage();
        educationLanguage.setName(dto.getName());
        educationLanguage.setCreatedAt(LocalDateTime.now());
        educationLanguageRepository.save(educationLanguage);
        return dto;
    }
    public boolean update(Integer id, EducationLanguageDto dto) {
        EducationLanguage educationLanguage = getEntity(id);
        educationLanguage.setName(dto.getName());
        educationLanguage.setUpdatedAt(LocalDateTime.now());
        educationLanguageRepository.save(educationLanguage);
        return true;
    }
    public boolean delete(Integer id) {
        EducationLanguage educationLanguage = getEntity(id);
        educationLanguage.setDeletedAt(LocalDateTime.now());
        educationLanguageRepository.save(educationLanguage);
        return true;
    }
    private EducationLanguage getEntity(Integer id) {
        Optional<EducationLanguage> optional = educationLanguageRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("EducationLanguage not found");
        }
        return optional.get();
    }
}
