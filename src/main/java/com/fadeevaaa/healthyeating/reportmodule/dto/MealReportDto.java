package com.fadeevaaa.healthyeating.reportmodule.dto;

import com.fadeevaaa.healthyeating.mealmodule.module.dto.MealDto;

import java.sql.Date;
import java.util.List;

public class MealReportDto {

    private Date createDate;
    private List<MealDto> meals;


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<MealDto> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDto> meals) {
        this.meals = meals;
    }
}
