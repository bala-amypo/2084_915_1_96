package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String role;
    private String teamName;
    private boolean active;

    public EmployeeProfile() {}

    public EmployeeProfile(String fullName, String email, String role, String teamName, boolean active) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.teamName = teamName;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
