package com.example.demo.controller;

import com.example.demo.dto.EmployeeProfileDto;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {
    
    private final EmployeeProfileService employeeProfileService;
    
    public EmployeeProfileController(EmployeeProfileService employeeProfileService) {
        this.employeeProfileService = employeeProfileService;
    }
    
    @PostMapping
    public ResponseEntity<EmployeeProfileDto> create(@RequestBody EmployeeProfileDto dto) {
        EmployeeProfileDto created = employeeProfileService.create(dto);
        return ResponseEntity.ok(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeProfileDto> update(@PathVariable Long id, @RequestBody EmployeeProfileDto dto) {
        EmployeeProfileDto updated = employeeProfileService.update(id, dto);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeProfileDto> getById(@PathVariable Long id) {
        EmployeeProfileDto employee = employeeProfileService.getById(id);
        return ResponseEntity.ok(employee);
    }
    
    @GetMapping("/team/{teamName}")
    public ResponseEntity<List<EmployeeProfileDto>> getByTeam(@PathVariable String teamName) {
        List<EmployeeProfileDto> employees = employeeProfileService.getByTeam(teamName);
        return ResponseEntity.ok(employees);
    }
}