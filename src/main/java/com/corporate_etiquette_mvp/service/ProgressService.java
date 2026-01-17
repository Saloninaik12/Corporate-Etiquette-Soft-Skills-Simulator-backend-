package com.corporate_etiquette_mvp.service;

import com.corporate_etiquette_mvp.model.Progress;
import java.util.List;

public interface ProgressService {
    Progress createProgress(Progress progress);
    Progress getProgressById(Integer id);
    List<Progress> getAllProgress();
    Progress updateProgress(Integer id, Progress progress);
    void deleteProgress(Integer id);
}
