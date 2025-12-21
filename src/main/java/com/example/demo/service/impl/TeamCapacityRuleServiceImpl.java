package com.example.demo.service.impl;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.TeamCapacityRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamCapacityRuleServiceImpl implements TeamCapacityRuleService {

    @Autowired
    private TeamCapacityConfigRepository repository;

    @Override
    public TeamCapacityConfig createRule(TeamCapacityConfig rule) {
        return repository.save(rule);
    }

    @Override
    public List<TeamCapacityConfig> getAllRules() {
        return repository.findAll();
    }
}
