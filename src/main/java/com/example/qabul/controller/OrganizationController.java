package com.example.qabul.controller;

import com.example.qabul.dto.OrganizationDto;
import com.example.qabul.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        OrganizationDto result = organizationService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid OrganizationDto dto) {
        OrganizationDto result = organizationService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid OrganizationDto dto) {
        boolean result = organizationService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = organizationService.delete(id);
        return ResponseEntity.ok(result);
    }
}
