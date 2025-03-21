package com.fadeevaaa.healthyeating.mealmodule.repository;

import com.fadeevaaa.healthyeating.mealmodule.module.dto.MealDto;
import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    @Query("SELECT m FROM Meal m WHERE DATE(m.createDateTime) = :date AND m.user.id = :id " +
            "ORDER BY DATE(m.createDateTime) DESC")
    List<Meal> findByDate(Date date, Long id);

    @Query("SELECT new com.fadeevaaa.healthyeating.mealmodule.module.dto.MealDto(m.name)" +
            "FROM Meal m WHERE DATE(m.createDateTime) = :date AND m.user.id = :id " +
            "ORDER BY DATE(m.createDateTime) DESC")
    List<MealDto> findMealDtoByDate(Date date, Long id);

    @Query("SELECT FUNCTION('DATE', m.createDateTime) " +
            "FROM Meal m WHERE m.user.id = :id GROUP BY FUNCTION('DATE', m.createDateTime) " +
            "ORDER BY FUNCTION('DATE', m.createDateTime) DESC")
    List<Date> findAllGroupedByUserAndDateIgnoringTime(Long id);
}
