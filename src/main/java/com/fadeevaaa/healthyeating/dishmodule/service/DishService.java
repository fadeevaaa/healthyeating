package com.fadeevaaa.healthyeating.dishmodule.service;

import com.fadeevaaa.healthyeating.dishmodule.model.entity.Dish;
import org.springframework.stereotype.Service;

@Service
public interface DishService {

    Dish create(Dish dish);
}
