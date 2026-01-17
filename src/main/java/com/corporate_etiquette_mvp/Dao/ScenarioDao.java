package com.corporate_etiquette_mvp.Dao;

import com.corporate_etiquette_mvp.model.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioDao extends JpaRepository<Scenario, Integer> {
    // New method to find scenarios by the userId
    List<Scenario> findByCreatedByUserId(Integer userId);
}