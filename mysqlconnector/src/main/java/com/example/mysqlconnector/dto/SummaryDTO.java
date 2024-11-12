package com.example.mysqlconnector.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SummaryDTO {

    private LocalDate date;
    private BigDecimal protein;

    // Constructor
    public SummaryDTO(LocalDate date, BigDecimal protein) {
        this.date = date;
        this.protein = protein;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }
}
