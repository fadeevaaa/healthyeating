package com.fadeevaaa.healthyeating.reportmodule.service;

import com.fadeevaaa.healthyeating.dishmodule.model.entity.Dish;
import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import com.fadeevaaa.healthyeating.mealmodule.repository.MealRepository;
import com.fadeevaaa.healthyeating.reportmodule.dto.MealReportDto;
import com.fadeevaaa.healthyeating.usermodule.model.entity.User;
import com.fadeevaaa.healthyeating.usermodule.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService{

    private final MealRepository mealRepository;
    private final UserRepository userRepository;

    public ReportServiceImpl(MealRepository mealRepository, UserRepository userRepository) {
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
    }

    private void checkUserByID(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NoSuchElementException("Пользователь не найден.");
        }
    }

    public String generateDailyReport(long id, Date date) {
        checkUserByID(id);
        List<Meal> meals = listOfUserMealsPerDay(id, date);
        long mealsCount = meals.size();
        int sumOfCalories = calculateCaloriesPerDay(meals);
        return "Количество приемов пищи: " + mealsCount + "\n" + "Сумма калорий: " + sumOfCalories;
    }

    private List<Meal> listOfUserMealsPerDay(long id, Date date) {
        return mealRepository.findByDate(date, id);
    }

    private int calculateCaloriesPerDay(List<Meal> meals) {
        return meals.stream().map(this::calculateCaloriesPerMeal).
                reduce(0, Integer::sum);
    }

    private int calculateCaloriesPerMeal(Meal meal) {
        return meal.getDishes().stream().map(Dish::getNumberOfCaloriesPerBatch).
                reduce(0, Integer::sum);
    }

    public String checkComplianceWithNorm(long id, Date date) {
        checkUserByID(id);
        List<Meal> meals = listOfUserMealsPerDay(id, date);
        int sumOfCaloriesPerDay = calculateCaloriesPerDay(meals);
        int dailyNorm;
        dailyNorm = userRepository.findById(id).get().getDailyNorm();
        if (sumOfCaloriesPerDay > dailyNorm) {
            return "Сумма калорий превышает дневную норму.";
        }
        else return "Пользователь уложился в дневную норму калорий.";
    }

    @Override
    public List<MealReportDto> generateFoodHistoryByDay(long id) {
        checkUserByID(id);
        List<Date> dates = mealRepository.findAllGroupedByUserAndDateIgnoringTime(id);
        return dates.stream().map(date -> convertToMealReportDto(date, id)).collect(Collectors.toList());
    }

    private MealReportDto convertToMealReportDto(Date date, long id) {
        MealReportDto dto = new MealReportDto();
        dto.setCreateDate(date);
        dto.setMeals(mealRepository.findMealDtoByDate(date, id));
        return dto;
    }
}
