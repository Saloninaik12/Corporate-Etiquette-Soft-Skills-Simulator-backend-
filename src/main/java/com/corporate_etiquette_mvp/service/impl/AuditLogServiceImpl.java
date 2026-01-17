package com.corporate_etiquette_mvp.service.impl;

import com.corporate_etiquette_mvp.Dao.AuditLogDao;
import com.corporate_etiquette_mvp.model.AuditLog;
import com.corporate_etiquette_mvp.service.AuditLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogDao auditLogDao;

    public AuditLogServiceImpl(AuditLogDao auditLogDao) {
        this.auditLogDao = auditLogDao;
    }

    @Override
    public AuditLog updateLog(Integer id, AuditLog updatedLog) {
        AuditLog log = auditLogDao.findById(id)
                .orElseThrow(() -> new RuntimeException("AuditLog not found with id " + id));

        log.setAction(updatedLog.getAction());
        log.setEntityType(updatedLog.getEntityType());
        log.setEntityId(updatedLog.getEntityId());
        log.setDetails(updatedLog.getDetails());
        log.setTimestamp(LocalDateTime.now());

        return auditLogDao.save(log);
    }

    @Override
    public AuditLog createLog(AuditLog log) {
        return auditLogDao.save(log);
    }

    @Override
    public AuditLog getLogById(Integer id) {
        return auditLogDao.findById(id).orElse(null);
    }

    @Override
    public List<AuditLog> getAllLogs() {
        return auditLogDao.findAll();
    }

    @Override
    public void deleteLog(Integer id) {
        auditLogDao.deleteById(id);
    }
}

