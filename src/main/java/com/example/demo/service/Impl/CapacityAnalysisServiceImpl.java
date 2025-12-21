package com.example.demo.service.impl;

import com.example.demo.dto.CapacityAnalysisResultDto;
import com.example.demo.model.LeaveRequest;
import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.CapacityAnalysisService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CapacityAnalysisServiceImpl implements CapacityAnalysisService {

    private final LeaveRequestRepository leaveRepository;
    private final TeamCapacityConfigRepository configRepository;

    public CapacityAnalysisServiceImpl(
            LeaveRequestRepository leaveRepository,
            TeamCapacityConfigRepository configRepository) {
        this.leaveRepository = leaveRepository;
        this.configRepository = configRepository;
    }

    @Override
    public CapacityAnalysisResultDto analyzeTeamCapacity(
            String teamName,
            LocalDate start,
            LocalDate end) {

        TeamCapacityConfig config = configRepository.findByTeamName(teamName);
        if (config == null) {
            throw new RuntimeException("Capacity config not found");
        }

        List<LeaveRequest> leaves =
                leaveRepository.findApprovedOverlappingForTeam(teamName, start, end);

        Map<LocalDate, Double> capacityByDate = new HashMap<>();

        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            long onLeave = leaves.stream()
                    .filter(l -> !date.isBefore(l.getStartDate())
                            && !date.isAfter(l.getEndDate()))
                    .count();

            double available =
                    ((double) (config.getTotalHeadcount() - onLeave)
                            / config.getTotalHeadcount()) * 100;

            capacityByDate.put(date, available);
        }

        boolean risky = capacityByDate.values().stream()
                .anyMatch(v -> v < config.getMinCapacityPercent());

        return new CapacityAnalysisResultDto(risky, capacityByDate);
    }
}
