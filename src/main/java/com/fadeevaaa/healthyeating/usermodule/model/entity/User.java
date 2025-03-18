package com.fadeevaaa.healthyeating.usermodule.model.entity;

import com.fadeevaaa.healthyeating.usermodule.model.enums.Purpose;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private byte age;
    private short weight;
    private short height;
    @Enumerated(EnumType.STRING)
    private Purpose purpose;
    @Column(name = "daily_norm")
    double dailyNorm;

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public double getDailyNorm() {
        return dailyNorm;
    }

    public void setDailyNorm(double dailyNorm) {
        this.dailyNorm = dailyNorm;
    }
}
