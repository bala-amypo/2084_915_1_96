package com.example.demo.controller;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/capacity-rules")
public class TeamCapacityRuleController {
    
    private final TeamCapacityRuleService teamCapacityRuleService;
    
    public TeamCapacityRuleController(TeamCapacityRuleService teamCapacityRuleService) {
        this.teamCapacityRuleService = teamCapacityRuleService;
    }
    
    @PostMapping
    public ResponseEntity<TeamCapacityConfig> create(@RequestBody TeamCapacityConfig rule) {
        TeamCapacityConfig created = teamCapacityRuleService.createRule(rule);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/team/{teamName}")
    public ResponseEntity<TeamCapacityConfig> getByTeam(@PathVariable String teamName) {
        TeamCapacityConfig rule = teamCapacityRuleService.getRuleByTeam(teamName);
        return ResponseEntity.ok(rule);
    }
}