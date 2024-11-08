package com.example.mysqlconnector.controller;

import com.example.mysqlconnector.dto.BiometricDTO;
import com.example.mysqlconnector.service.BiometricService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biometrics")
public class BiometricController {

    private final BiometricService biometricService;

    public BiometricController(BiometricService biometricService) {
        this.biometricService = biometricService;
    }

    @GetMapping
    public List<BiometricDTO> getBiometrics(
        @RequestParam(required = false) String groupName,
        @RequestParam(required = false) String metric,
        @RequestParam(required = false) String unit
    ) {
        return biometricService.getBiometrics(groupName, metric, unit);
    }
}
