package com.corporate_etiquette_mvp.Dao;

import com.corporate_etiquette_mvp.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentDao extends JpaRepository<Assignment, Integer> {
}
