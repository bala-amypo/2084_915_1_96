package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.TeamCapacityRuleService;
import org.springframework.stereotype.Service;

@Service
public class TeamCapacityRuleServiceImpl implements TeamCapacityRuleService {

    private final TeamCapacityConfigRepository repository;

    public TeamCapacityRuleServiceImpl(TeamCapacityConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeamCapacityConfig createRule(TeamCapacityConfig rule) {
        return repository.save(rule);
    }

    @Override
    public TeamCapacityConfig updateRule(Long id, TeamCapacityConfig updatedRule) {
        TeamCapacityConfig existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Capacity rule not found"));

        existing.setTeamName(updatedRule.getTeamName());
        existing.setTotalHeadcount(updatedRule.getTotalHeadcount());
        existing.setMinCapacityPercent(updatedRule.getMinCapacityPercent());

        return repository.save(existing);
    }

    @Override
    public TeamCapacityConfig getRuleByTeam(String teamName) {
        TeamCapacityConfig rule = repository.findByTeamName(teamName);
        if (rule == null) {
            throw new RuntimeException("Capacity config not found");
        }
        return rule;
    }
}
