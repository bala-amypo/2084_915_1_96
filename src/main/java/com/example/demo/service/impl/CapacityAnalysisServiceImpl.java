package com.example.demo.service.impl;

import com.example.demo.dto.CapacityAnalysisResultDto;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.model.LeaveRequest;
import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.CapacityAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CapacityAnalysisServiceImpl implements CapacityAnalysisService {

    @Autowired
    private TeamCapacityConfigRepository teamRepo;

    @Autowired
    private EmployeeProfileRepository employeeRepo;

    @Autowired
    private LeaveRequestRepository leaveRepo;

    @Override
    public CapacityAnalysisResultDto analyzeCapacity(String teamName) {

        List<EmployeeProfile> teamMembers = employeeRepo.findByTeamName(teamName);
        int totalMembers = teamMembers.size();

        Map<LocalDate, Double> dailyCapacity = new HashMap<>();
        boolean capacityRisk = false;

        List<LeaveRequest> leaves = leaveRepo.findAll();

        for (EmployeeProfile emp : teamMembers) {
            for (LeaveRequest leave : leaves) {
                if (leave.getStatus().equals("APPROVED") && leave.getEmployee().getId().equals(emp.getId())) {
                    LocalDate start = leave.getStartDate();
                    LocalDate end = leave.getEndDate();
                    while (!start.isAfter(end)) {
                        dailyCapacity.put(start, dailyCapacity.getOrDefault(start, (double) totalMembers) - 1);
                        start = start.plusDays(1);
                    }
                }
            }
        }

        TeamCapacityConfig config = teamRepo.findByTeamName(teamName).orElse(null);
        if (config != null) {
            for (Double cap : dailyCapacity.values()) {
                double percent = (cap / totalMembers) * 100;
                if (percent < config.getMinCapacityPercent()) {
                    capacityRisk = true;
                    break;
                }
            }
        }

        return new CapacityAnalysisResultDto(capacityRisk, dailyCapacity);
    }
}
