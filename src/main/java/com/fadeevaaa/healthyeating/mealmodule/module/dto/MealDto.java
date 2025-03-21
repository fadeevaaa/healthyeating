package com.fadeevaaa.healthyeating.mealmodule.module.dto;

public class MealDto {
    private String name;

    public MealDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
