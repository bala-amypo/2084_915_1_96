package com.example.demo.repository;

import com.example.demo.model.TeamCapacityConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamCapacityConfigRepository
        extends JpaRepository<TeamCapacityConfig, Long> {

    TeamCapacityConfig findByTeamName(String teamName);
}
