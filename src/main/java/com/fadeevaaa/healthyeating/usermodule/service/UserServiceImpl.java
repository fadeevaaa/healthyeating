package com.fadeevaaa.healthyeating.usermodule.service;

import com.fadeevaaa.healthyeating.usermodule.model.entity.User;
import com.fadeevaaa.healthyeating.usermodule.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> create(@Valid User user) {
        int dailyNorm = calculateDailyNorm(user.getWeight(), user.getHeight(), user.getAge());
        user.setDailyNorm(dailyNorm);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public int calculateDailyNorm(int weight, int height, int age) {
        return (int) (88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age));
    }
}
