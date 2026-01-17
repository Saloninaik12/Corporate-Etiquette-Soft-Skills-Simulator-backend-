package com.corporate_etiquette_mvp.Dao;

import com.corporate_etiquette_mvp.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDao extends JpaRepository<Feedback, Integer> {
}

