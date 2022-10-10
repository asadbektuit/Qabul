package com.example.qabul.controller;

import com.example.qabul.dto.StudyFormDto;
import com.example.qabul.service.StudyFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/study-form")
public class StudyFormController {

    @Autowired
    private StudyFormService studyFormService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        StudyFormDto result = studyFormService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid StudyFormDto dto) {
        StudyFormDto result = studyFormService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid StudyFormDto dto) {
        boolean result = studyFormService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = studyFormService.delete(id);
        return ResponseEntity.ok(result);
    }


}
