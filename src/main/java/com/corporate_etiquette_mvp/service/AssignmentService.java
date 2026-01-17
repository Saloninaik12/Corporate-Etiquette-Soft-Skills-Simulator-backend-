package com.corporate_etiquette_mvp.service;

import com.corporate_etiquette_mvp.model.Assignment;
import java.util.List;

public interface AssignmentService {
    Assignment createAssignment(Assignment assignment);
    Assignment getAssignmentById(Integer id);
    Assignment updateAssignment(Integer id, Assignment updatedAssignment);
    List<Assignment> getAllAssignments();
    void deleteAssignment(Integer id);
}
