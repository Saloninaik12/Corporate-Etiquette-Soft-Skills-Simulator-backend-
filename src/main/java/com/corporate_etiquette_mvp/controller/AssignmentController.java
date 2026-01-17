package com.corporate_etiquette_mvp.controller;

import com.corporate_etiquette_mvp.model.Assignment;
import com.corporate_etiquette_mvp.service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @GetMapping("/{id}")
    public Assignment getAssignment(@PathVariable Integer id) {
        return assignmentService.getAssignmentById(id);
    }

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Integer id) {
        assignmentService.deleteAssignment(id);
    }
    @PutMapping("/{id}")
    public Assignment updateAssignment(@PathVariable Integer id, @RequestBody Assignment updatedAssignment) {
        return assignmentService.updateAssignment(id, updatedAssignment);
    }
}

