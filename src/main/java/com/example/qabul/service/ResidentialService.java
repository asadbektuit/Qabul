package com.example.qabul.service;

import com.example.qabul.dto.DegreeDto;
import com.example.qabul.dto.ResidentialDto;
import com.example.qabul.entity.Degree;
import com.example.qabul.entity.Residential;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.DegreeRepository;
import com.example.qabul.repository.ResidentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ResidentialService {
    @Autowired
    private ResidentialRepository residentialRepository;

    public ResidentialDto get(Integer id) {
        Residential residential = getEntity(id);
        ResidentialDto dto = new ResidentialDto();
        dto.setName(residential.getName());;
        return dto;
    }
    public ResidentialDto create(ResidentialDto dto) {
        Residential residential = new Residential();
        residential.setName(dto.getName());
        residential.setCreatedAt(LocalDateTime.now());
        residentialRepository.save(residential);
        return dto;
    }
    public boolean update(Integer id, ResidentialDto dto) {
        Residential residential = getEntity(id);
        residential.setName(dto.getName());
        residential.setUpdatedAt(LocalDateTime.now());
        residentialRepository.save(residential);
        return true;
    }
    public boolean delete(Integer id) {
        Residential residential = getEntity(id);
        residential.setDeletedAt(LocalDateTime.now());
        residentialRepository.save(residential);
        return true;
    }
    private Residential getEntity(Integer id) {
        Optional<Residential> optional = residentialRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("Degree not found");
        }
        return optional.get();
    }
}
