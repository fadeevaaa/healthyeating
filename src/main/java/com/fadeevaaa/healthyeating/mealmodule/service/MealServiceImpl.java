package com.fadeevaaa.healthyeating.mealmodule.service;

import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import com.fadeevaaa.healthyeating.mealmodule.repository.MealRepository;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal create(Meal meal) {
        return mealRepository.save(meal);
    }
}
