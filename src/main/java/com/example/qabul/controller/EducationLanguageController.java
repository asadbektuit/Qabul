package com.example.qabul.controller;

import com.example.qabul.dto.EducationLanguageDto;
import com.example.qabul.service.EducationLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/education-language")
public class EducationLanguageController {

    @Autowired
    private EducationLanguageService educationLanguageService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        EducationLanguageDto result = educationLanguageService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid EducationLanguageDto dto) {
        EducationLanguageDto result = educationLanguageService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid EducationLanguageDto dto) {
        boolean result = educationLanguageService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = educationLanguageService.delete(id);
        return ResponseEntity.ok(result);
    }
}
