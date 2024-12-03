package com.example.mysqlconnector.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ServingDTO {

    private LocalDate date;
    private String groupName;
    private String foodName;
    private String amount;
    private BigDecimal calories;
    private BigDecimal protein;

    // Constructor
    public ServingDTO(LocalDate date, String groupName, String foodName, String amount, BigDecimal calories, BigDecimal protein) {
        this.date = date;
        this.groupName = groupName;
        this.foodName = foodName;
        this.amount = amount;
        this.calories = calories;
        this.protein = protein;
    }

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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }
}
