package com.fadeevaaa.healthyeating.dishmodule.controller;

import com.fadeevaaa.healthyeating.dishmodule.model.entity.Dish;
import com.fadeevaaa.healthyeating.dishmodule.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody Dish dish) {
        dishService.create(dish);
    }
}
