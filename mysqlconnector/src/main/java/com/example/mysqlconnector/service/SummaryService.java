package com.example.mysqlconnector.service;

import com.example.mysqlconnector.dto.SummaryDTO;
import com.example.mysqlconnector.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService {

    @Autowired
    private final SummaryRepository summaryRepository;

    public SummaryService(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    public List<SummaryDTO> getSummaries(String date, String calories, String protein) {
        return summaryRepository.findByDateAndCaloriesAndProtein(date, calories, protein);
    }
}
