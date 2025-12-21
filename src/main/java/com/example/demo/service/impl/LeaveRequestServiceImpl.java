package com.example.demo.service.impl;

import com.example.demo.model.LeaveRequest;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Override
    public LeaveRequest applyLeave(LeaveRequest leave) {
        leave.setStatus("PENDING");
        return leaveRequestRepository.save(leave);
    }

    @Override
    public LeaveRequest approveLeave(Long id) {
        LeaveRequest leave = leaveRequestRepository.findById(id).orElseThrow();
        leave.setStatus("APPROVED");
        return leaveRequestRepository.save(leave);
    }

    @Override
    public LeaveRequest rejectLeave(Long id) {
        LeaveRequest leave = leaveRequestRepository.findById(id).orElseThrow();
        leave.setStatus("REJECTED");
        return leaveRequestRepository.save(leave);
    }

    @Override
    public List<LeaveRequest> getAllLeaves() {
        return leaveRequestRepository.findAll();
    }
}
