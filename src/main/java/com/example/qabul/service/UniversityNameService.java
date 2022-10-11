package com.example.qabul.service;

import com.example.qabul.dto.UniversityNameDto;
import com.example.qabul.entity.UniversityName;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.UniversityNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UniversityNameService {
    @Autowired
    private UniversityNameRepository universityNameRepository;

    public UniversityNameDto get(Integer id) {
        UniversityName universityName = getEntity(id);
        UniversityNameDto dto = new UniversityNameDto();
        dto.setName(universityName.getName());;
        return dto;
    }
    public UniversityNameDto create(UniversityNameDto dto) {
        UniversityName universityName = new UniversityName();
        universityName.setName(dto.getName());
        universityName.setCreatedAt(LocalDateTime.now());
        universityNameRepository.save(universityName);
        return dto;
    }
    public boolean update(Integer id, UniversityNameDto dto) {
        UniversityName universityName = getEntity(id);
        universityName.setName(dto.getName());
        universityName.setUpdatedAt(LocalDateTime.now());
        universityNameRepository.save(universityName);
        return true;
    }
    public boolean delete(Integer id) {
        UniversityName universityName = getEntity(id);
        universityName.setDeletedAt(LocalDateTime.now());
        universityNameRepository.save(universityName);
        return true;
    }
    private UniversityName getEntity(Integer id) {
        Optional<UniversityName> optional = universityNameRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("University name not found");
        }
        return optional.get();
    }
}
