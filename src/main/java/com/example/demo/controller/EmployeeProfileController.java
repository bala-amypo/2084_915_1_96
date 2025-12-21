package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Management")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    // POST /api/employees
    @PostMapping
    public EmployeeProfile createEmployee(@RequestBody EmployeeProfile employee) {
        return service.create(employee);
    }

    // GET /api/employees/{id}
    @GetMapping("/{id}")
    public EmployeeProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET /api/employees/team/{teamName}
    @GetMapping("/team/{teamName}")
    public List<EmployeeProfile> getByTeam(@PathVariable String teamName) {
        return service.getByTeam(teamName);
    }

    // GET /api/employees
    @GetMapping
    public List<EmployeeProfile> getAll() {
        return service.getAll();
    }
}
