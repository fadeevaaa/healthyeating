package com.fadeevaaa.healthyeating.usermodule.service;

import com.fadeevaaa.healthyeating.usermodule.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User create(User user);
}
