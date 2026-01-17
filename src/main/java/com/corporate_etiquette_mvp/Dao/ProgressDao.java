package com.corporate_etiquette_mvp.Dao;

import com.corporate_etiquette_mvp.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressDao extends JpaRepository<Progress, Integer> {
}
