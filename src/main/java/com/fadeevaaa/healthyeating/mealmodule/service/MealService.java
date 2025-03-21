package com.fadeevaaa.healthyeating.mealmodule.service;

import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import org.springframework.stereotype.Service;

@Service
public interface MealService {

    Meal create(Meal meal);
}
