package com.example.qabul.service;

import com.example.qabul.dto.DegreeDto;
import com.example.qabul.dto.SportRazryadVaUnvoniDto;
import com.example.qabul.entity.Degree;
import com.example.qabul.entity.SportRazryadVaUnvoni;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.DegreeRepository;
import com.example.qabul.repository.SportRvaURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SportRazryadVaUnvoniService {
    @Autowired
    private SportRvaURepository sportRvaURepository;

    public SportRazryadVaUnvoniDto get(Integer id) {
        SportRazryadVaUnvoni sportRazryadVaUnvoni = getEntity(id);
        SportRazryadVaUnvoniDto dto = new SportRazryadVaUnvoniDto();
        dto.setName(sportRazryadVaUnvoni.getName());;
        return dto;
    }
    public SportRazryadVaUnvoniDto create(SportRazryadVaUnvoniDto dto) {
        SportRazryadVaUnvoni sportRazryadVaUnvoni = new SportRazryadVaUnvoni();
        sportRazryadVaUnvoni.setName(dto.getName());
        sportRazryadVaUnvoni.setCreatedAt(LocalDateTime.now());
        sportRvaURepository.save(sportRazryadVaUnvoni);
        return dto;
    }
    public boolean update(Integer id, SportRazryadVaUnvoniDto dto) {
        SportRazryadVaUnvoni sportRazryadVaUnvoni = getEntity(id);
        sportRazryadVaUnvoni.setName(dto.getName());
        sportRazryadVaUnvoni.setUpdatedAt(LocalDateTime.now());
        sportRvaURepository.save(sportRazryadVaUnvoni);
        return true;
    }
    public boolean delete(Integer id) {
        SportRazryadVaUnvoni sportRazryadVaUnvoni = getEntity(id);
        sportRazryadVaUnvoni.setDeletedAt(LocalDateTime.now());
        sportRvaURepository.save(sportRazryadVaUnvoni);
        return true;
    }
    private SportRazryadVaUnvoni getEntity(Integer id) {
        Optional<SportRazryadVaUnvoni> optional = sportRvaURepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("SportRazryadVaUnvoni not found");
        }
        return optional.get();
    }
}
