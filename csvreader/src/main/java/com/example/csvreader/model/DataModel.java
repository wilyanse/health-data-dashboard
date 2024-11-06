package com.example.csvreader.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataModel {

    @JsonProperty("Day") // Make sure this matches the header in your CSV file
    private String column1;

    @JsonProperty("Group")
    private String column2;

    @JsonProperty("Metric")
    private String column3;

    @JsonProperty("Unit")
    private String column4;

    @JsonProperty("Amount")
    private String column5;

    // Add more columns as needed
}
