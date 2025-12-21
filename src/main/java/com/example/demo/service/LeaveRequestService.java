package com.example.demo.service;

import com.example.demo.model.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {

    LeaveRequest applyLeave(LeaveRequest leave);

    LeaveRequest approveLeave(Long id);

    LeaveRequest rejectLeave(Long id);

    List<LeaveRequest> getAllLeaves();
}
