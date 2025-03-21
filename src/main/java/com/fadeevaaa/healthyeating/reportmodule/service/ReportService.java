package com.fadeevaaa.healthyeating.reportmodule.service;

import com.fadeevaaa.healthyeating.reportmodule.dto.MealReportDto;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface ReportService {

    String generateDailyReport(long id, Date date);

    String checkComplianceWithNorm(long id, Date date);

    List<MealReportDto> generateFoodHistoryByDay(long id);
}
