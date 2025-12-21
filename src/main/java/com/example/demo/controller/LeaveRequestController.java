package com.example.demo.controller;

import com.example.demo.model.LeaveRequest;
import com.example.demo.service.LeaveRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@Tag(name = "Leave Management")
public class LeaveRequestController {

    private final LeaveRequestService service;

    public LeaveRequestController(LeaveRequestService service) {
        this.service = service;
    }

    // POST /api/leaves
    @PostMapping
    public LeaveRequest submitLeave(@RequestBody LeaveRequest request) {
        return service.create(request);
    }

    // PUT /api/leaves/{id}/approve
    @PutMapping("/{id}/approve")
    public LeaveRequest approve(@PathVariable Long id) {
        return service.approve(id);
    }

    // PUT /api/leaves/{id}/reject
    @PutMapping("/{id}/reject")
    public LeaveRequest reject(@PathVariable Long id) {
        return service.reject(id);
    }

    // GET /api/leaves/employee/{employeeId}
    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getByEmployee(@PathVariable Long employeeId) {
        return service.getByEmployee(employeeId);
    }

    // GET /api/leaves/team/{teamName}
    @GetMapping("/team/{teamName}")
    public List<LeaveRequest> getOverlappingForTeam(
            @PathVariable String teamName,
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return service.getOverlappingForTeam(teamName, start, end);
    }
}
