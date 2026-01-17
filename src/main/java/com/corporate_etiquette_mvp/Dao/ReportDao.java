package com.corporate_etiquette_mvp.Dao;

import com.corporate_etiquette_mvp.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportDao extends JpaRepository<Report, Integer> {
}
