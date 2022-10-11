package com.example.qabul.controller;

import com.example.qabul.dto.UniversityNameDto;
import com.example.qabul.service.UniversityNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/university-name")
public class UniversityNameController {
    @Autowired
    private UniversityNameService universityNameService;


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        UniversityNameDto result = universityNameService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UniversityNameDto dto) {
        UniversityNameDto result = universityNameService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid UniversityNameDto dto) {
        boolean result = universityNameService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = universityNameService.delete(id);
        return ResponseEntity.ok(result);
    }
}
