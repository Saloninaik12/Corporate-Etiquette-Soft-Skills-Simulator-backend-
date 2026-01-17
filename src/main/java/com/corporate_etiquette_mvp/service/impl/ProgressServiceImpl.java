package com.corporate_etiquette_mvp.service.impl;

import com.corporate_etiquette_mvp.Dao.ProgressDao;
import com.corporate_etiquette_mvp.model.Progress;
import com.corporate_etiquette_mvp.service.ProgressService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {

    private final ProgressDao progressDao;

    public ProgressServiceImpl(ProgressDao progressDao) {
        this.progressDao = progressDao;
    }

    @Override
    public Progress createProgress(Progress progress) {
        return progressDao.save(progress);
    }

    @Override
    public Progress getProgressById(Integer id) {
        return progressDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Progress not found with id " + id));
    }

    @Override
    public List<Progress> getAllProgress() {
        return progressDao.findAll();
    }

    @Override
    public Progress updateProgress(Integer id, Progress updatedProgress) {
        Progress progress = progressDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Progress not found with id " + id));

        progress.setCompletionPercentage(updatedProgress.getCompletionPercentage());
        progress.setLastAccessed(LocalDateTime.now());

        return progressDao.save(progress);
    }

    @Override
    public void deleteProgress(Integer id) {
        progressDao.deleteById(id);
    }
}

