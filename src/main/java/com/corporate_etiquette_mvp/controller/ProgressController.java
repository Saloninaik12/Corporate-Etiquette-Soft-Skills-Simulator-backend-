package com.corporate_etiquette_mvp.controller;

import com.corporate_etiquette_mvp.model.Progress;
import com.corporate_etiquette_mvp.service.ProgressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    // POST - Create progress
    @PostMapping
    public Progress createProgress(@RequestBody Progress progress) {
        return progressService.createProgress(progress);
    }

    // GET - Get progress by ID
    @GetMapping("/{id}")
    public Progress getProgressById(@PathVariable Integer id) {
        return progressService.getProgressById(id);
    }

    // GET - Get all progress records
    @GetMapping
    public List<Progress> getAllProgress() {
        return progressService.getAllProgress();
    }

    // PUT - Update progress
    @PutMapping("/{id}")
    public Progress updateProgress(@PathVariable Integer id, @RequestBody Progress progress) {
        return progressService.updateProgress(id, progress);
    }

    // DELETE - Delete progress
    @DeleteMapping("/{id}")
    public void deleteProgress(@PathVariable Integer id) {
        progressService.deleteProgress(id);
    }
}

