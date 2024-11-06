package com.example.csvreader.controller;

import com.example.csvreader.service.CsvReaderService;
import com.example.csvreader.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CsvController {

    @Autowired
    private CsvReaderService csvReaderService;

    @GetMapping("/csvdata")
    public ResponseEntity<List<DataModel>> getCsvData() {
        try {
            List<DataModel> data = csvReaderService.readCsv();
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
