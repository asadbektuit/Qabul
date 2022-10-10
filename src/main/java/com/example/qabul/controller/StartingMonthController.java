package com.example.qabul.controller;

import com.example.qabul.dto.StartingMonthDto;
import com.example.qabul.service.StartingMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/starting-month")
public class StartingMonthController {
    @Autowired
    private StartingMonthService startingMonthService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        StartingMonthDto result = startingMonthService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid StartingMonthDto dto) {
        StartingMonthDto result = startingMonthService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid StartingMonthDto dto) {
        boolean result = startingMonthService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = startingMonthService.delete(id);
        return ResponseEntity.ok(result);
    }
}
