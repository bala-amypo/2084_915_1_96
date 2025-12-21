package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    @Autowired
    private EmployeeProfileRepository employeeProfileRepository;

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        return employeeProfileRepository.save(employee);
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return employeeProfileRepository.findAll();
    }

    @Override
    public List<EmployeeProfile> getEmployeesByTeam(String teamName) {
        return employeeProfileRepository.findByTeamName(teamName);
    }
}
