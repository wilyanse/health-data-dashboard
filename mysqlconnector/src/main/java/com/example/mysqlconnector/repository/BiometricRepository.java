package main.java.com.example.mysqlconnector.repository;

import main.java.com.example.mysqlconnector.entity.Biometric;
import main.java.com.example.mysqlconnector.dto.BiometricDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BiometricRepository extends JpaRepository<Biometric, Integer> {

    // Example of a dynamic query method using JPQL with DTO projection
    @Query("SELECT new com.example.healthdata.dto.BiometricDTO(b.date, b.groupName, b.metric, b.unit, b.amount) " +
           "FROM Biometric b " +
           "WHERE (:groupName IS NULL OR b.groupName = :groupName) " +
           "AND (:metric IS NULL OR b.metric = :metric)")
    List<BiometricDTO> findByGroupNameAndMetric(
        @Param("groupName") String groupName, 
        @Param("metric") String metric
    );
}