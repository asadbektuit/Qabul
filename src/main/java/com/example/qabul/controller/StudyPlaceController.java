package com.example.qabul.controller;

import com.example.qabul.dto.StudyPlaceDto;
import com.example.qabul.service.StudyPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/study-place")
public class StudyPlaceController {

    @Autowired
    private StudyPlaceService studyPlaceService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        StudyPlaceDto result = studyPlaceService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid StudyPlaceDto dto) {
        StudyPlaceDto result = studyPlaceService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid StudyPlaceDto dto) {
        boolean result = studyPlaceService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = studyPlaceService.delete(id);
        return ResponseEntity.ok(result);
    }
}
