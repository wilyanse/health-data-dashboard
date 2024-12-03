package com.example.mysqlconnector.controller;

import com.example.mysqlconnector.entity.Serving;
import com.example.mysqlconnector.dto.ServingDTO;
import com.example.mysqlconnector.service.ServingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/servings")
public class ServingController {

    @Autowired
    private final ServingService servingService;

    public ServingController(ServingService servingService) {
        this.servingService = servingService;
    }

    @GetMapping
    public List<ServingDTO> getServings(
        @RequestParam(required = false) String date,
        @RequestParam(required = false) String groupName,
        @RequestParam(required = false) String foodName,
        @RequestParam(required = false) String amount,
        @RequestParam(required = false) String calories,
        @RequestParam(required = false) String protein
    ) {
        return servingService.getServings(date, groupName, foodName, amount, calories, protein);
    }
}
