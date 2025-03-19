package com.fadeevaaa.healthyeating.reportmodule.controller;

import com.fadeevaaa.healthyeating.reportmodule.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{id}")
    public String showUserDailySumOfCaloriesAndMeals(@PathVariable("id") Long id,
                                                     @RequestParam("date") LocalDate date) {
        return reportService.generateDailyReport(id, date);
    }
}
