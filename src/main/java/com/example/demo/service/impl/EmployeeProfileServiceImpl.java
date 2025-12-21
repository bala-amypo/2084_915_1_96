package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeProfile create(EmployeeProfile employee) {
        employee.setActive(true);
        return repository.save(employee);
    }

    @Override
    public EmployeeProfile update(Long id, EmployeeProfile employee) {
        EmployeeProfile existing = getById(id);
        existing.setFullName(employee.getFullName());
        existing.setEmail(employee.getEmail());
        existing.setTeamName(employee.getTeamName());
        existing.setRole(employee.getRole());
        return repository.save(existing);
    }

    @Override
    public void deactivate(Long id) {
        EmployeeProfile emp = getById(id);
        emp.setActive(false);
        repository.save(emp);
    }

    @Override
    public EmployeeProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeProfile> getByTeam(String teamName) {
        return repository.findByTeamNameAndActiveTrue(teamName);
    }

    @Override
    public List<EmployeeProfile> getAll() {
        return repository.findAll();
    }
}
