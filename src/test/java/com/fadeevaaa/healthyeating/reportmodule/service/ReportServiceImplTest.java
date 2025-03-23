package com.fadeevaaa.healthyeating.reportmodule.service;

import com.fadeevaaa.healthyeating.dishmodule.model.entity.Dish;
import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import com.fadeevaaa.healthyeating.mealmodule.repository.MealRepository;
import com.fadeevaaa.healthyeating.usermodule.model.entity.User;
import com.fadeevaaa.healthyeating.usermodule.model.enums.Purpose;
import com.fadeevaaa.healthyeating.usermodule.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReportServiceImplTest {

    User user = new User("Vanya", "vanya@gmail.com", 25, 70, 170, Purpose.MAINTENANCE);
    Dish dish = new Dish("яйцо", 100);
    Dish dish1 = new Dish("яблоко", 60);
    List<Meal> meals = List.of(new Meal("завтрак", user, List.of(dish)),
            new Meal("перекус", user, List.of(dish1)));
    Date date = new Date(System.currentTimeMillis());

    @Mock
    private MealRepository mealRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private ReportServiceImpl reportServiceImpl;

    @Test
    void generateDailyReportTest() {
        when(mealRepository.findByDate(date, 1L)).thenReturn(meals);
        String expected = "Количество приемов пищи: 2\nСумма калорий: 160";
        Assertions.assertEquals(expected,
                reportServiceImpl.generateDailyReport(1, date));
    }

    @Test
    void checkComplianceWithNormSuccessfulTest() {
        user.setDailyNorm(200);
        when(mealRepository.findByDate(date, 1L)).thenReturn(meals);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        String expected = "Пользователь уложился в дневную норму калорий.";
        Assertions.assertEquals(expected, reportServiceImpl.checkComplianceWithNorm(1, date));
    }

    @Test
    void checkComplianceWithNormFailedTest() {
        user.setDailyNorm(100);
        when(mealRepository.findByDate(date, 1L)).thenReturn(meals);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        String expected = "Сумма калорий превышает дневную норму.";
        Assertions.assertEquals(expected, reportServiceImpl.checkComplianceWithNorm(1, date));
    }
}
