package com.example.qabul.controller;

import com.example.qabul.dto.SportTypeDto;
import com.example.qabul.service.SportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/sport-type")
public class SportTypeController {
    @Autowired
    private SportTypeService sportTypeService;
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        SportTypeDto result = sportTypeService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SportTypeDto dto) {
        SportTypeDto result = sportTypeService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid SportTypeDto dto) {
        boolean result = sportTypeService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = sportTypeService.delete(id);
        return ResponseEntity.ok(result);
    }
}
