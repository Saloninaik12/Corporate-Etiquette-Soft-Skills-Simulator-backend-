package com.corporate_etiquette_mvp.service.impl;

import com.corporate_etiquette_mvp.Dao.ReportDao;
import com.corporate_etiquette_mvp.model.Report;
import com.corporate_etiquette_mvp.service.ReportService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportDao reportDao;

    public ReportServiceImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Override
    public Report createReport(Report report) {
        return reportDao.save(report);
    }

    @Override
    public Report getReportById(Integer id) {
        return reportDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));
    }

    @Override
    public List<Report> getAllReports() {
        return reportDao.findAll();
    }

    @Override
    public Report updateReport(Integer id, Report updatedReport) {
        Report report = reportDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));

        report.setReportType(updatedReport.getReportType());
        report.setContent(updatedReport.getContent());
        report.setUpdatedAt(LocalDateTime.now());

        return reportDao.save(report);
    }

    @Override
    public void deleteReport(Integer id) {
        reportDao.deleteById(id);
    }
}
