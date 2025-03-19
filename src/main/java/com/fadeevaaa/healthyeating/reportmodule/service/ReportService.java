package com.fadeevaaa.healthyeating.reportmodule.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public interface ReportService {

    public String generateDailyReport(long id, LocalDate date);
}
