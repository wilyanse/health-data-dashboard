package com.example.mysqlconnector.repository;

import com.example.mysqlconnector.entity.Serving;
import com.example.mysqlconnector.dto.ServingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ServingRepository extends JpaRepository<Serving, Integer> {

    // Example of a dynamic query method using JPQL with DTO projection
    @Query("SELECT new com.example.mysqlconnector.dto.ServingDTO(b.date, b.groupName, b.foodName, b.amount, b.calories, b.protein) " +
           "FROM Serving b " +
           "WHERE (:date IS NULL OR b.date = :date) " +
           "AND (:groupName IS NULL OR b.groupName = :groupName)" +
           "AND (:foodName IS NULL OR b.foodName = :foodName)" +
           "AND (:amount IS NULL OR b.amount = :amount)" +
           "AND (:calories IS NULL OR b.calories = :calories)" +
           "AND (:protein IS NULL OR b.protein = :protein)" +
           "ORDER BY b.date"
           )
    List<ServingDTO> findByDateAndGroupNameAndFoodNameAndAmountAndCaloriesAndProtein(
        @Param("date") String date,
        @Param("groupName") String groupName,
        @Param("foodName") String foodName,
        @Param("amount") String amount,
        @Param("calories") String calories,
        @Param("protein") String protein
    );

    
}