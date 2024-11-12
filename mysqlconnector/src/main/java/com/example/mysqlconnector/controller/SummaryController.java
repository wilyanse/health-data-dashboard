package com.example.mysqlconnector.controller;

import com.example.mysqlconnector.entity.Summary;
import com.example.mysqlconnector.dto.SummaryDTO;
import com.example.mysqlconnector.service.SummaryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/dailysummaries")
public class SummaryController {

    @Autowired
    private final SummaryService summaryService;

    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping
    public List<SummaryDTO> getSummaries(
        @RequestParam(required = false) String date,
        @RequestParam(required = false) String protein
    ) {
        return summaryService.getSummaries(date, protein);
    }
}
