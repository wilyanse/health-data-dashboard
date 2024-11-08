package com.example.mysqlconnector.service;

import com.example.mysqlconnector.dto.BiometricDTO;
import com.example.mysqlconnector.entity.Biometric;
import com.example.mysqlconnector.repository.BiometricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
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

    @Autowired
    private EntityManager entityManager;

    public List<Biometric> findBiometricsWithOrder(String sortBy, String sortDirection) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Biometric> cq = cb.createQuery(Biometric.class);
        Root<Biometric> biometric = cq.from(Biometric.class);

        // Set the sorting criteria
        if ("desc".equalsIgnoreCase(sortDirection)) {
            cq.orderBy(cb.desc(biometric.get(sortBy)));
        } else {
            cq.orderBy(cb.asc(biometric.get(sortBy)));
        }

        // Build the query and get results
        return entityManager.createQuery(cq).getResultList();
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
