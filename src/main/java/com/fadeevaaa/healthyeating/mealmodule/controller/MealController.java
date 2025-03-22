package com.fadeevaaa.healthyeating.mealmodule.controller;

import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import com.fadeevaaa.healthyeating.mealmodule.service.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meals")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addMeal(@RequestBody Meal meal) {
        mealService.create(meal);
    }
}
