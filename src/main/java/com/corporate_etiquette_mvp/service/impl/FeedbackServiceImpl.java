package com.corporate_etiquette_mvp.service.impl;

import com.corporate_etiquette_mvp.Dao.FeedbackDao;
import com.corporate_etiquette_mvp.model.Feedback;
import com.corporate_etiquette_mvp.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackDao feedbackDao;

    public FeedbackServiceImpl(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackDao.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Integer id) {
        return feedbackDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found with id " + id));
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.findAll();
    }

    @Override
    public Feedback updateFeedback(Integer id, Feedback updatedFeedback) {
        Feedback feedback = feedbackDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found with id " + id));

        feedback.setComments(updatedFeedback.getComments());
        feedback.setRating(updatedFeedback.getRating());
        feedback.setUpdatedAt(LocalDateTime.now());

        return feedbackDao.save(feedback);
    }

    @Override
    public void deleteFeedback(Integer id) {
        feedbackDao.deleteById(id);
    }
}
