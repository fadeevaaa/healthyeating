package com.fadeevaaa.healthyeating.usermodule.service;

import com.fadeevaaa.healthyeating.usermodule.model.entity.User;
import com.fadeevaaa.healthyeating.usermodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        short dailyNorm = calculateDailyNorm(user.getWeight(), user.getHeight(), user.getAge());
        user.setDailyNorm(dailyNorm);
        return userRepository.save(user);
    }

    public short calculateDailyNorm(short weight, short height, byte age) {
        return (short) (88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age));
    }
}
