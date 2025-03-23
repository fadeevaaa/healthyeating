package com.fadeevaaa.healthyeating.reportmodule.controller;

import com.fadeevaaa.healthyeating.reportmodule.dto.MealReportDto;
import com.fadeevaaa.healthyeating.reportmodule.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/reports/{id}")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping()
    public String showUserDailySumOfCaloriesAndMeals(@PathVariable("id") Long id,
                                                     @RequestParam("date") Date date) {
        return reportService.generateDailyReport(id, date);
    }

    @GetMapping("/comparison")
    public String checkComplianceWithNorm(@PathVariable("id") Long id, @RequestParam("date") Date date) {
        return reportService.checkComplianceWithNorm(id, date);
    }

    @GetMapping("/history")
    public ResponseEntity<List<MealReportDto>> showFoodHistoryByDay(@PathVariable("id") Long id) {
        List<MealReportDto> report = reportService.generateFoodHistoryByDay(id);
        return ResponseEntity.ok(report);
    }
}
