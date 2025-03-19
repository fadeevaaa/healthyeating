package com.fadeevaaa.healthyeating.reportmodule.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MealReportDto {
    private long mealId;
    private String mealName;
    private LocalDateTime createDateTime;
    private List<DishReportDto> dishes;

    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public List<DishReportDto> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishReportDto> dishes) {
        this.dishes = dishes;
    }
}
