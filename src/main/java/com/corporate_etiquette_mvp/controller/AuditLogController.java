package com.corporate_etiquette_mvp.controller;

import com.corporate_etiquette_mvp.model.AuditLog;
import com.corporate_etiquette_mvp.service.AuditLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    private final AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public AuditLog createLog(@RequestBody AuditLog log) {
        return auditLogService.createLog(log);
    }

    @PutMapping("/{id}")
    public AuditLog updateLog(@PathVariable Integer id, @RequestBody AuditLog updatedLog) {
        return auditLogService.updateLog(id, updatedLog);
    }

    @GetMapping("/{id}")
    public AuditLog getLog(@PathVariable Integer id) {
        return auditLogService.getLogById(id);
    }

    @GetMapping
    public List<AuditLog> getAllLogs() {
        return auditLogService.getAllLogs();
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Integer id) {
        auditLogService.deleteLog(id);
    }
}
