package com.corporate_etiquette_mvp.service.impl;

import com.corporate_etiquette_mvp.Dao.AssignmentDao;
import com.corporate_etiquette_mvp.model.Assignment;
import com.corporate_etiquette_mvp.service.AssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentDao assignmentDao;

    public AssignmentServiceImpl(AssignmentDao assignmentDao) {
        this.assignmentDao = assignmentDao;
    }

    // ✅ PUT update
    @Override
    public Assignment updateAssignment(Integer id, Assignment updatedAssignment) {
        Assignment assignment = assignmentDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id " + id));

        assignment.setStatus(updatedAssignment.getStatus());
        assignment.setCompletedAt(updatedAssignment.getCompletedAt());

        return assignmentDao.save(assignment);
    }
    @Override
    public Assignment createAssignment(Assignment assignment) {
        return assignmentDao.save(assignment);
    }

    @Override
    public Assignment getAssignmentById(Integer id) {
        return assignmentDao.findById(id).orElse(null);
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentDao.findAll();
    }

    @Override
    public void deleteAssignment(Integer id) {
        assignmentDao.deleteById(id);
    }
}

