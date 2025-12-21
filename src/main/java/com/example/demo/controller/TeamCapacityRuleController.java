package com.example.demo.controller;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/capacity-rules")
@Tag(name = "Team Capacity Rules")
public class TeamCapacityRuleController {

    private final TeamCapacityRuleService service;

    public TeamCapacityRuleController(TeamCapacityRuleService service) {
        this.service = service;
    }

    // POST /api/capacity-rules
    @PostMapping
    public TeamCapacityConfig create(@RequestBody TeamCapacityConfig rule) {
        return service.createRule(rule);
    }

    // PUT /api/capacity-rules/{id}
    @PutMapping("/{id}")
    public TeamCapacityConfig update(
            @PathVariable Long id,
            @RequestBody TeamCapacityConfig rule) {
        return service.updateRule(id, rule);
    }

    // GET /api/capacity-rules/{teamName}
    @GetMapping("/{teamName}")
    public TeamCapacityConfig getByTeam(@PathVariable String teamName) {
        return service.getRuleByTeam(teamName);
    }
}
