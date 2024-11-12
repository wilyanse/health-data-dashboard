package com.example.mysqlconnector.repository;

import com.example.mysqlconnector.entity.Summary;
import com.example.mysqlconnector.dto.SummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SummaryRepository extends JpaRepository<Summary, Integer> {

    // Example of a dynamic query method using JPQL with DTO projection
    @Query("SELECT new com.example.mysqlconnector.dto.SummaryDTO(b.date, b.calories, b.protein) " +
           "FROM Summary b " +
           "WHERE (:date IS NULL OR b.date = :date) " +
           "AND (:calories IS NULL OR b.calories = :calories)" +
           "AND (:protein IS NULL OR b.protein = :protein)")
    List<SummaryDTO> findByDateAndCaloriesAndProtein(
        @Param("date") String date, 
        @Param("calories") String calories,
        @Param("protein") String protein
    );

    
}