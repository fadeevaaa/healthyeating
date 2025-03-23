package com.fadeevaaa.healthyeating.dishmodule.service;

import com.fadeevaaa.healthyeating.dishmodule.model.entity.Dish;
import com.fadeevaaa.healthyeating.dishmodule.repository.DishRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DishServiceImplTest {

    Dish dish = new Dish("яйцо", 100);

    @Mock
    private DishRepository dishRepository;
    @InjectMocks
    private DishServiceImpl dishService;

    @Test
    void create() {
        dishService.create(dish);
        verify(dishRepository).save(dish);
    }
}
