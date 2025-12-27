package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {
    
    private final EmployeeProfileRepository employeeProfileRepository;
    
    public EmployeeProfileServiceImpl(EmployeeProfileRepository employeeProfileRepository) {
        this.employeeProfileRepository = employeeProfileRepository;
    }
    
    @Override
    public EmployeeProfileDto create(EmployeeProfileDto dto) {
        EmployeeProfile employee = new EmployeeProfile();
        employee.setEmployeeId(dto.getEmployeeId());
        employee.setFullName(dto.getFullName());
        employee.setEmail(dto.getEmail());
        employee.setTeamName(dto.getTeamName());
        employee.setRole(dto.getRole());
        
        EmployeeProfile saved = employeeProfileRepository.save(employee);
        return toDto(saved);
    }
    
    @Override
    public EmployeeProfileDto update(Long id, EmployeeProfileDto dto) {
        EmployeeProfile employee = employeeProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        
        employee.setFullName(dto.getFullName());
        employee.setTeamName(dto.getTeamName());
        employee.setRole(dto.getRole());
        
        EmployeeProfile saved = employeeProfileRepository.save(employee);
        return toDto(saved);
    }
    
    @Override
    public void deactivate(Long id) {
        EmployeeProfile employee = employeeProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        
        employee.setActive(false);
        employeeProfileRepository.save(employee);
    }
    
    @Override
    public EmployeeProfileDto getById(Long id) {
        EmployeeProfile employee = employeeProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return toDto(employee);
    }
    
    @Override
    public List<EmployeeProfileDto> getByTeam(String teamName) {
        return employeeProfileRepository.findByTeamNameAndActiveTrue(teamName)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<EmployeeProfileDto> getAll() {
        return employeeProfileRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
    private EmployeeProfileDto toDto(EmployeeProfile employee) {
        EmployeeProfileDto dto = new EmployeeProfileDto();
        dto.setId(employee.getId());
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setFullName(employee.getFullName());
        dto.setEmail(employee.getEmail());
        dto.setTeamName(employee.getTeamName());
        dto.setRole(employee.getRole());
        return dto;
    }
}