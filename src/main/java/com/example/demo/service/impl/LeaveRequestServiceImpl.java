package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.model.LeaveRequest;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRepository;
    private final EmployeeProfileRepository employeeRepository;

    public LeaveRequestServiceImpl(
            LeaveRequestRepository leaveRepository,
            EmployeeProfileRepository employeeRepository) {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public LeaveRequest create(LeaveRequest request) {
        request.setStatus("PENDING");
        return leaveRepository.save(request);
    }

    @Override
    public LeaveRequest approve(Long id) {
        LeaveRequest leave = leaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setStatus("APPROVED");
        return leaveRepository.save(leave);
    }

    @Override
    public LeaveRequest reject(Long id) {
        LeaveRequest leave = leaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setStatus("REJECTED");
        return leaveRepository.save(leave);
    }

    @Override
    public List<LeaveRequest> getByEmployee(Long employeeId) {
        EmployeeProfile employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return leaveRepository.findByEmployee(employee);
    }

    @Override
    public List<LeaveRequest> getOverlappingForTeam(
            String teamName,
            LocalDate start,
            LocalDate end) {

        return leaveRepository.findApprovedOverlappingForTeam(
                teamName, start, end);
    }
}
