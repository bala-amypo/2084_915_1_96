package com.example.demo.controller;

import com.example.demo.model.LeaveRequest;
import com.example.demo.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping
    public ResponseEntity<LeaveRequest> applyLeave(@RequestBody LeaveRequest leave) {
        return ResponseEntity.ok(leaveRequestService.applyLeave(leave));
    }

    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaves() {
        return ResponseEntity.ok(leaveRequestService.getAllLeaves());
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<LeaveRequest> approveLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveRequestService.approveLeave(id));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<LeaveRequest> rejectLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveRequestService.rejectLeave(id));
    }
}
