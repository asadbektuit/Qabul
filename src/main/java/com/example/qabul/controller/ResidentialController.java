package com.example.qabul.controller;

import com.example.qabul.dto.ResidentialDto;
import com.example.qabul.service.ResidentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/residential")
public class ResidentialController {

    @Autowired
    private ResidentialService residentialService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        ResidentialDto result = residentialService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ResidentialDto dto) {
        ResidentialDto result = residentialService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid ResidentialDto dto) {
        boolean result = residentialService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = residentialService.delete(id);
        return ResponseEntity.ok(result);
    }
}
