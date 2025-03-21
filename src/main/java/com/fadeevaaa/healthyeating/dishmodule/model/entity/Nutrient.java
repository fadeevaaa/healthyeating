package com.fadeevaaa.healthyeating.dishmodule.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.PositiveOrZero;

@Embeddable
public class Nutrient {
    @PositiveOrZero
    private double proteins;
    @PositiveOrZero
    private double fats;
    @PositiveOrZero
    private double carbohydrates;

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
