package com.example.demo.service;

import com.example.demo.model.TeamCapacityConfig;

import java.util.List;

public interface TeamCapacityRuleService {

    TeamCapacityConfig createRule(TeamCapacityConfig rule);

    List<TeamCapacityConfig> getAllRules();
}
