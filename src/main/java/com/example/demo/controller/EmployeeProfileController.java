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
        return ResponseEntity.ok(employeeProfileService.createEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeProfile>> getAllEmployees() {
        return ResponseEntity.ok(employeeProfileService.getAllEmployees());
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<List<EmployeeProfile>> getEmployeesByTeam(@PathVariable String teamName) {
        return ResponseEntity.ok(employeeProfileService.getEmployeesByTeam(teamName));
    }
}
