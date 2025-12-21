package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    List<EmployeeProfile> getAllEmployees();

    List<EmployeeProfile> getEmployeesByTeam(String teamName);
}
