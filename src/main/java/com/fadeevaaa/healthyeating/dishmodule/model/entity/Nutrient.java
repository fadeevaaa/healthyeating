package com.fadeevaaa.healthyeating.dishmodule.model.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Nutrient {
    private double proteins;
    private double fats;
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
