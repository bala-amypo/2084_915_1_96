package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {

    @Autowired
    private EmployeeProfileService employeeProfileService;

    @PostMapping
    public ResponseEntity<EmployeeProfile> createEmployee(@RequestBody EmployeeProfile employee) {
        EmployeeProfile saved = employeeProfileService.createEmployee(employee);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeProfile>> getAllEmployees() {
        return ResponseEntity.ok(employeeProfileService.getAllEmployees());
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<List<EmployeeProfile>> getByTeam(@PathVariable String teamName) {
        return ResponseEntity.ok(employeeProfileService.getEmployeesByTeam(teamName));
    }
}
