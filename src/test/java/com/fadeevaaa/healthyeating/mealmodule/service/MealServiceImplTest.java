package com.fadeevaaa.healthyeating.mealmodule.service;

import com.fadeevaaa.healthyeating.dishmodule.model.entity.Dish;
import com.fadeevaaa.healthyeating.dishmodule.repository.DishRepository;
import com.fadeevaaa.healthyeating.dishmodule.service.DishServiceImpl;
import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import com.fadeevaaa.healthyeating.mealmodule.repository.MealRepository;
import com.fadeevaaa.healthyeating.usermodule.model.entity.User;
import com.fadeevaaa.healthyeating.usermodule.model.enums.Purpose;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MealServiceImplTest {

    User user = new User("Vanya", "vanya@gmail.com", 25, 70, 170, Purpose.MAINTENANCE);
    Dish dish = new Dish("яйцо", 100);
    Meal meal = new Meal("завтрак", user, List.of(dish));

    @Mock
    private MealRepository mealRepository;
    @InjectMocks
    private MealServiceImpl mealService;

    @Test
    void create() {
        mealService.create(meal);
        verify(mealRepository).save(meal);
    }
}
