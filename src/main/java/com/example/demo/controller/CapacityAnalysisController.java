package com.example.demo.controller;

import com.example.demo.dto.CapacityAnalysisResultDto;
import com.example.demo.service.CapacityAnalysisService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/capacity-analysis")
@Tag(name = "Capacity Analysis")
public class CapacityAnalysisController {

    private final CapacityAnalysisService service;

    public CapacityAnalysisController(CapacityAnalysisService service) {
        this.service = service;
    }

    // GET /api/capacity-analysis
    @GetMapping
    public CapacityAnalysisResultDto analyze(
            @RequestParam String teamName,
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return service.analyzeTeamCapacity(teamName, start, end);
    }
}
