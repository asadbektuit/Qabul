package com.example.qabul.service;

import com.example.qabul.dto.DegreeDto;
import com.example.qabul.entity.Degree;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DegreeService {

    @Autowired
    private DegreeRepository degreeRepository;

    public DegreeDto get(Integer id) {
        Degree degree = getEntity(id);
        DegreeDto dto = new DegreeDto();
        dto.setName(degree.getName());;
        return dto;
    }
    public DegreeDto create(DegreeDto dto) {
        Degree degree = new Degree();
        degree.setName(dto.getName());
        degree.setCreatedAt(LocalDateTime.now());
        degreeRepository.save(degree);
        return dto;
    }
    public boolean update(Integer id, DegreeDto dto) {
        Degree degree = getEntity(id);
        degree.setName(dto.getName());
        degree.setUpdatedAt(LocalDateTime.now());
        degreeRepository.save(degree);
        return true;
    }
    public boolean delete(Integer id) {
        Degree degree = getEntity(id);
        degree.setDeletedAt(LocalDateTime.now());
        degreeRepository.save(degree);
        return true;
    }
    private Degree getEntity(Integer id) {
        Optional<Degree> optional = degreeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("Degree not found");
        }
        return optional.get();
    }
}
