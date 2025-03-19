package com.fadeevaaa.healthyeating.dishmodule.model.entity;

import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private short numberOfCaloriesPerBatch;
    @Embedded
    private Nutrient nutrient;
//    @ManyToMany()
//    @JoinTable(name = "meal_dish",
//            joinColumns = @JoinColumn(name = "dish_id"),
//            inverseJoinColumns = @JoinColumn(name = "meal_id")
//    )
//    private List<Meal> meals = new ArrayList<>();

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

    public short getNumberOfCaloriesPerBatch() {
        return numberOfCaloriesPerBatch;
    }

    public void setNumberOfCaloriesPerBatch(short numberOfCaloriesPerBatch) {
        this.numberOfCaloriesPerBatch = numberOfCaloriesPerBatch;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }
}
