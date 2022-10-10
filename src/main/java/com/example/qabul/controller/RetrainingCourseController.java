package com.example.qabul.controller;

import com.example.qabul.dto.RetrainingCourseDto;
import com.example.qabul.service.RetrainingCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/retraining-course")
public class RetrainingCourseController {

    @Autowired
    private RetrainingCourseService retrainingCourseService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        RetrainingCourseDto result = retrainingCourseService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid RetrainingCourseDto dto) {
        RetrainingCourseDto result = retrainingCourseService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid RetrainingCourseDto dto) {
        boolean result = retrainingCourseService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = retrainingCourseService.delete(id);
        return ResponseEntity.ok(result);
    }
}
