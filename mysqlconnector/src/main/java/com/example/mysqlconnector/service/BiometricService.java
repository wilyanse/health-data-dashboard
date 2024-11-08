package com.example.mysqlconnector.service;

import com.example.mysqlconnector.dto.BiometricDTO;
import com.example.mysqlconnector.repository.BiometricRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BiometricService {

    private final BiometricRepository biometricRepository;

    public BiometricService(BiometricRepository biometricRepository) {
        this.biometricRepository = biometricRepository;
    }

    public List<BiometricDTO> getBiometrics(String groupName, String metric, String unit) {
        return biometricRepository.findByGroupNameAndMetricAndUnit(groupName, metric, unit);
    }
}
