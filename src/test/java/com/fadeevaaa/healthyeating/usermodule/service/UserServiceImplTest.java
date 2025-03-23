package com.fadeevaaa.healthyeating.usermodule.service;

import com.fadeevaaa.healthyeating.usermodule.model.entity.User;
import com.fadeevaaa.healthyeating.usermodule.model.enums.Purpose;
import com.fadeevaaa.healthyeating.usermodule.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    User user = new User("Vanya", "vanya@gmail.com", 25, 70, 170, Purpose.MAINTENANCE);

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    void createSuccessfulTest() {
        userServiceImpl.create(user);
        assertTrue(user.getDailyNorm() != 0);
        verify(userRepository).save(user);
    }

    @Test
    void calculateDailyNorm() {
        int actual = userServiceImpl.calculateDailyNorm(user.getWeight(), user.getHeight(), user.getAge());
        assertEquals(1699, actual);
    }
}
