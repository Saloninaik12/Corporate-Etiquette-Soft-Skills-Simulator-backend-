package com.corporate_etiquette_mvp.service;

import com.corporate_etiquette_mvp.model.Report;
import java.util.List;

public interface ReportService {
    Report createReport(Report report);
    Report getReportById(Integer id);
    List<Report> getAllReports();
    Report updateReport(Integer id, Report report);
    void deleteReport(Integer id);
}

