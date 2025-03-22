package com.fadeevaaa.healthyeating.dishmodule.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @PositiveOrZero
    private int numberOfCaloriesPerBatch;
    @Embedded
    @Valid
    private Nutrient nutrient;

    public Dish() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCaloriesPerBatch() {
        return numberOfCaloriesPerBatch;
    }

    public void setNumberOfCaloriesPerBatch(int numberOfCaloriesPerBatch) {
        this.numberOfCaloriesPerBatch = numberOfCaloriesPerBatch;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", numberOfCaloriesPerBatch=" + numberOfCaloriesPerBatch +
                '}';
    }
}
