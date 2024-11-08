package main.java.com.example.mysqlconnector.service;

import main.java.com.example.mysqlconnector.dto.BiometricDTO;
import main.java.com.example.mysqlconnector.repository.BiometricRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BiometricService {

    private final BiometricRepository biometricRepository;

    public BiometricService(BiometricRepository biometricRepository) {
        this.biometricRepository = biometricRepository;
    }

    public List<BiometricDTO> getBiometrics(String groupName, String metric) {
        return biometricRepository.findByGroupNameAndMetric(groupName, metric);
    }
}
