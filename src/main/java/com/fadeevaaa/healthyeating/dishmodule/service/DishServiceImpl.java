package com.fadeevaaa.healthyeating.dishmodule.service;

import com.fadeevaaa.healthyeating.dishmodule.model.entity.Dish;
import com.fadeevaaa.healthyeating.dishmodule.repository.DishRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish create(@Valid Dish dish) {
        return dishRepository.save(dish);
    }
}
