package com.example.mysqlconnector.repository;

import com.example.mysqlconnector.entity.Biometric;
import com.example.mysqlconnector.dto.BiometricDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BiometricRepository extends JpaRepository<Biometric, Integer> {

    // Example of a dynamic query method using JPQL with DTO projection
    @Query("SELECT new com.example.mysqlconnector.dto.BiometricDTO(b.date, b.groupName, b.metric, b.unit, b.amount) " +
           "FROM Biometric b " +
           "WHERE (:groupName IS NULL OR b.groupName = :groupName) " +
           "AND (:metric IS NULL OR b.metric = :metric)" +
           "AND (:unit IS NULL OR b.unit = :unit)")
    List<BiometricDTO> findByGroupNameAndMetricAndUnit(
        @Param("groupName") String groupName, 
        @Param("metric") String metric,
        @Param("unit") String unit
    );
}