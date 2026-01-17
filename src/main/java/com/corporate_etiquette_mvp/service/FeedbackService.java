package com.corporate_etiquette_mvp.service;

import com.corporate_etiquette_mvp.model.Feedback;
import java.util.List;

public interface FeedbackService {
    Feedback createFeedback(Feedback feedback);
    Feedback getFeedbackById(Integer id);
    List<Feedback> getAllFeedbacks();
    Feedback updateFeedback(Integer id, Feedback feedback);
    void deleteFeedback(Integer id);
}
