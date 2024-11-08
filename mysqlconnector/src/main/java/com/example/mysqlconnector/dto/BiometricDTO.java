package main.java.com.example.mysqlconnector.dto;

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
}
