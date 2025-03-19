package com.fadeevaaa.healthyeating.mealmodule.repository;

import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findAllByUserIdAndCreateDateTimeBetween(
            long userId, LocalDateTime startDate, LocalDateTime endDate);

//    long countByUserId(Long userId);

//    List<User> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

}
