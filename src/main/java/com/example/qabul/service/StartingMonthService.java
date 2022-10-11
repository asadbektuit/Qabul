package com.example.qabul.service;

import com.example.qabul.dto.DegreeDto;
import com.example.qabul.dto.StartingMonthDto;
import com.example.qabul.entity.Degree;
import com.example.qabul.entity.StartingMonth;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.DegreeRepository;
import com.example.qabul.repository.StartingMonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StartingMonthService {
    @Autowired
    private StartingMonthRepository startingMonthRepository;

    public StartingMonthDto get(Integer id) {
        StartingMonth startingMonth = getEntity(id);
        StartingMonthDto dto = new StartingMonthDto();
        dto.setName(startingMonth.getName());;
        return dto;
    }
    public StartingMonthDto create(StartingMonthDto dto) {
        StartingMonth startingMonth = new StartingMonth();
        startingMonth.setName(dto.getName());
        startingMonth.setCreatedAt(LocalDateTime.now());
        startingMonthRepository.save(startingMonth);
        return dto;
    }
    public boolean update(Integer id, StartingMonthDto dto) {
        StartingMonth startingMonth = getEntity(id);
        startingMonth.setName(dto.getName());
        startingMonth.setUpdatedAt(LocalDateTime.now());
        startingMonthRepository.save(startingMonth);
        return true;
    }
    public boolean delete(Integer id) {
        StartingMonth startingMonth = getEntity(id);
        startingMonth.setDeletedAt(LocalDateTime.now());
        startingMonthRepository.save(startingMonth);
        return true;
    }
    private StartingMonth getEntity(Integer id) {
        Optional<StartingMonth> optional = startingMonthRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("StartingMonth not found");
        }
        return optional.get();
    }
}
