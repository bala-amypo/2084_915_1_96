package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TeamCapacityConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private int totalHeadcount;
    private double minCapacityPercent;

    public TeamCapacityConfig() {}

    public TeamCapacityConfig(String teamName, int totalHeadcount, double minCapacityPercent) {
        this.teamName = teamName;
        this.totalHeadcount = totalHeadcount;
        this.minCapacityPercent = minCapacityPercent;
    }

    public Long getId() { return id; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public int getTotalHeadcount() { return totalHeadcount; }
    public void setTotalHeadcount(int totalHeadcount) { this.totalHeadcount = totalHeadcount; }
    public double getMinCapacityPercent() { return minCapacityPercent; }
    public void setMinCapacityPercent(double minCapacityPercent) { this.minCapacityPercent = minCapacityPercent; }
}
