package com.example.demo.controller;

import com.example.demo.dto.CapacityAnalysisResultDto;
import com.example.demo.service.CapacityAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/capacity-analysis")
public class CapacityAnalysisController {

    @Autowired
    private CapacityAnalysisService capacityAnalysisService;

    @GetMapping("/{teamName}")
    public ResponseEntity<CapacityAnalysisResultDto> analyzeCapacity(@PathVariable String teamName) {
        CapacityAnalysisResultDto result = capacityAnalysisService.analyzeCapacity(teamName);
        return ResponseEntity.ok(result);
    }
}
