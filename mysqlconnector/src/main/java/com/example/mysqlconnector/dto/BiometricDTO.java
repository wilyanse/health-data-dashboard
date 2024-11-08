package com.example.mysqlconnector.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BiometricDTO {

    private LocalDate date;
    private String groupName;
    private String metric;
    private String unit;
    private BigDecimal amount;

    // Constructor
    public BiometricDTO(LocalDate date, String groupName, String metric, String unit, BigDecimal amount) {
        this.date = date;
        this.groupName = groupName;
        this.metric = metric;
        this.unit = unit;
        this.amount = amount;
    }

    // Getters and Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
