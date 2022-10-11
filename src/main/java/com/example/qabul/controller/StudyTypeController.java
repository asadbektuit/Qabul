package com.example.qabul.controller;

import com.example.qabul.dto.StudyTypeDto;
import com.example.qabul.service.StudyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/study-type")
public class StudyTypeController {
    @Autowired
    private StudyTypeService studyTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        StudyTypeDto result = studyTypeService.get(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid StudyTypeDto dto) {
        StudyTypeDto result = studyTypeService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid StudyTypeDto dto) {
        boolean result = studyTypeService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = studyTypeService.delete(id);
        return ResponseEntity.ok(result);
    }
}
