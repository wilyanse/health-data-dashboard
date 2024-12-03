package com.example.mysqlconnector.service;

import com.example.mysqlconnector.dto.ServingDTO;
import com.example.mysqlconnector.repository.ServingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServingService {

    @Autowired
    private final ServingRepository servingRepository;

    public ServingService(ServingRepository servingRepository) {
        this.servingRepository = servingRepository;
    }

    public List<ServingDTO> getServings(String date, String groupName, String foodName, String amount, String calories, String protein) {
        return servingRepository.findByDateAndGroupNameAndFoodNameAndAmountAndCaloriesAndProtein(date, groupName, foodName, amount, calories, protein);
    }
}
