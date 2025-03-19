package com.fadeevaaa.healthyeating.reportmodule.service;

import com.fadeevaaa.healthyeating.mealmodule.module.entity.Meal;
import com.fadeevaaa.healthyeating.mealmodule.repository.MealRepository;
import com.fadeevaaa.healthyeating.reportmodule.dto.MealReportDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    private final MealRepository mealRepository;

    public ReportServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public String generateDailyReport(long id, LocalDate date) {
//        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDate =
                LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 0, 0);
        LocalDateTime endDate =
                LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 23, 59);

        long mealsCount = mealRepository.findAllByUserIdAndCreateDateTimeBetween(id, startDate, endDate).size();
        return "Количество приемов пищи: " + mealsCount;
    }

//    public List<MealReportDto> generateDailyReport(long id) {
//        List<Meal> meals = mealRepository.findAllByUserId(id);
//    }

//    public List<UserReportDto> generateUserReport() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map(this::convertToUserReportDto)
//                .collect(Collectors.toList());
//    }
//
//    private UserReportDto convertToUserReportDto(User user) {
//        UserReportDto dto = new UserReportDto();
//        dto.setUserId(user.getId());
//        dto.setUserName(user.getName());
//        dto.setOrders(user.getOrders().stream()
//                .map(order -> new OrderReportDto(order.getId(), order.getOrderDate()))
//                .collect(Collectors.toList()));
//        return dto;
//    }
}
