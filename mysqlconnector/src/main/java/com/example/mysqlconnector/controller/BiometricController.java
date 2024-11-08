package com.example.mysqlconnector.controller;

import com.example.mysqlconnector.entity.Biometric;
import com.example.mysqlconnector.dto.BiometricDTO;
import com.example.mysqlconnector.service.BiometricService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/biometrics")
public class BiometricController {

    @Autowired
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

    @GetMapping("/sorted")
    public ResponseEntity<List<Biometric>> getBiometrics(
            @RequestParam(defaultValue = "date") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        List<Biometric> biometrics = biometricService.findBiometricsWithOrder(sortBy, sortDirection);
        return ResponseEntity.ok(biometrics);
    }

    @PostMapping
    public ResponseEntity<Biometric> addBiometric(@RequestBody BiometricDTO biometricDTO) {
        Biometric savedBiometric = biometricService.addBiometric(biometricDTO);
        return new ResponseEntity<>(savedBiometric, HttpStatus.CREATED);
    }
}
