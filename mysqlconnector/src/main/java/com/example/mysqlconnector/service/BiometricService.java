package com.example.mysqlconnector.service;

import com.example.mysqlconnector.dto.BiometricDTO;
import com.example.mysqlconnector.entity.Biometric;
import com.example.mysqlconnector.repository.BiometricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BiometricService {

    @Autowired
    private final BiometricRepository biometricRepository;

    public BiometricService(BiometricRepository biometricRepository) {
        this.biometricRepository = biometricRepository;
    }

    public List<BiometricDTO> getBiometrics(String groupName, String metric, String unit) {
        return biometricRepository.findByGroupNameAndMetricAndUnit(groupName, metric, unit);
    }

    public Biometric addBiometric(BiometricDTO biometricDTO) {
        Biometric biometric = new Biometric();
        biometric.setDate(biometricDTO.getDate());
        biometric.setGroupName(biometricDTO.getGroupName());
        biometric.setMetric(biometricDTO.getMetric());
        biometric.setUnit(biometricDTO.getUnit());
        biometric.setAmount(biometricDTO.getAmount());
        return biometricRepository.save(biometric);
    }
}
