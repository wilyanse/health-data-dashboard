package com.example.csvreader.controller;

import com.example.csvreader.service.CsvReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CsvController {

    @Autowired
    private CsvReaderService csvReaderService;

    // Dynamic endpoint using filename as path variable
    @GetMapping("/{fileName}")
    public List<Map<String, String>> getCsvData(@PathVariable String fileName) {
        return csvReaderService.readCsvFile(fileName + ".csv");
    }
}
