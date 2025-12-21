package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Map;

public class CapacityAnalysisResultDto {

    private boolean capacityRisk;
    private Map<LocalDate, Double> dailyCapacity;

    public CapacityAnalysisResultDto() {
    }

    public CapacityAnalysisResultDto(boolean capacityRisk, Map<LocalDate, Double> dailyCapacity) {
        this.capacityRisk = capacityRisk;
        this.dailyCapacity = dailyCapacity;
    }

    public boolean isCapacityRisk() {
        return capacityRisk;
    }

    public void setCapacityRisk(boolean capacityRisk) {
        this.capacityRisk = capacityRisk;
    }

    public Map<LocalDate, Double> getDailyCapacity() {
        return dailyCapacity;
    }

    public void setDailyCapacity(Map<LocalDate, Double> dailyCapacity) {
        this.dailyCapacity = dailyCapacity;
    }
}
