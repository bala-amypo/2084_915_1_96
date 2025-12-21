package com.example.demo.controller;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team-capacity")
public class TeamCapacityRuleController {

    @Autowired
    private TeamCapacityRuleService teamCapacityRuleService;

    @PostMapping
    public ResponseEntity<TeamCapacityConfig> createRule(@RequestBody TeamCapacityConfig rule) {
        return ResponseEntity.ok(teamCapacityRuleService.createRule(rule));
    }

    @GetMapping
    public ResponseEntity<List<TeamCapacityConfig>> getAllRules() {
        return ResponseEntity.ok(teamCapacityRuleService.getAllRules());
    }
}
