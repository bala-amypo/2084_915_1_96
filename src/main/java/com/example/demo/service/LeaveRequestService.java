package com.example.demo.service;

import com.example.demo.model.LeaveRequest;
import java.time.LocalDate;
import java.util.List;

public interface LeaveRequestService {

    LeaveRequest create(LeaveRequest request);

    LeaveRequest approve(Long id);

    LeaveRequest reject(Long id);

    List<LeaveRequest> getByEmployee(Long employeeId);

    List<LeaveRequest> getOverlappingForTeam(
            String teamName,
            LocalDate start,
            LocalDate end
    );
}
