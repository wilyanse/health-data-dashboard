package com.example.csvreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.csvreader")  // Ensure base package includes 'com.example.demo.config'
public class CsvreaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsvreaderApplication.class, args);
    }
}
