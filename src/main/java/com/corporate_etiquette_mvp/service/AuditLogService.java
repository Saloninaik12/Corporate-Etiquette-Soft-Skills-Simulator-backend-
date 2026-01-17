package com.corporate_etiquette_mvp.service;

import com.corporate_etiquette_mvp.model.AuditLog;

import java.util.List;

public interface AuditLogService {
    AuditLog createLog(AuditLog log);
    AuditLog getLogById(Integer id);
    AuditLog updateLog(Integer id, AuditLog updatedLog);

    List<AuditLog> getAllLogs();
    void deleteLog(Integer id);
}
