package main.java.com.example.mysqlconnector.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "biometrics")
public class Biometric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;
    
    @Column(name = "group_name")
    private String groupName;
    
    private String metric;
    
    private String unit;
    
    private BigDecimal amount;

    // Getters and Setters
}