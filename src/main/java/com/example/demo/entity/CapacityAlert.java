package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CapacityAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private LocalDate date;
    private Double availableCapacity;

    public CapacityAlert() {}

    public CapacityAlert(String teamName, LocalDate date, Double availableCapacity) {
        this.teamName = teamName;
        this.date = date;
        this.availableCapacity = availableCapacity;
    }

    public Long getId() { return id; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Double getAvailableCapacity() { return availableCapacity; }
    public void setAvailableCapacity(Double availableCapacity) { this.availableCapacity = availableCapacity; }
}
