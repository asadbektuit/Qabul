package com.example.qabul.controller;

import com.example.qabul.dto.SportRazryadVaUnvoniDto;
import com.example.qabul.service.SportRazryadVaUnvoniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/sport-razryadi-va-unvoni")
public class SportRazryadVaUnvoniController {
    @Autowired
    private SportRazryadVaUnvoniService sportRazryadVaUnvoniService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        SportRazryadVaUnvoniDto result = sportRazryadVaUnvoniService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SportRazryadVaUnvoniDto dto) {
        SportRazryadVaUnvoniDto result = sportRazryadVaUnvoniService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid SportRazryadVaUnvoniDto dto) {
        boolean result = sportRazryadVaUnvoniService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = sportRazryadVaUnvoniService.delete(id);
        return ResponseEntity.ok(result);
    }
}
