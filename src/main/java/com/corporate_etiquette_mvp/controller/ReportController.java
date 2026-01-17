package com.corporate_etiquette_mvp.controller;

import com.corporate_etiquette_mvp.model.Report;
import com.corporate_etiquette_mvp.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // POST - Create report
    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    // GET - Get report by ID
    @GetMapping("/{id}")
    public Report getReportById(@PathVariable Integer id) {
        return reportService.getReportById(id);
    }

    // GET - Get all reports
    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    // PUT - Update report
    @PutMapping("/{id}")
    public Report updateReport(@PathVariable Integer id, @RequestBody Report report) {
        return reportService.updateReport(id, report);
    }

    // DELETE - Delete report
    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Integer id) {
        reportService.deleteReport(id);
    }
}

