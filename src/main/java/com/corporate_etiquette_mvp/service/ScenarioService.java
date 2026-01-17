package com.corporate_etiquette_mvp.service;

import com.corporate_etiquette_mvp.model.Scenario;
import java.util.List;

public interface ScenarioService {
    Scenario saveScenario(Scenario scenario);
    Scenario createScenario(Scenario scenario);
    Scenario getScenarioById(Integer id);
    Scenario updateScenario(Integer id, Scenario updatedScenario);
    List<Scenario> getAllScenarios();
    void deleteScenario(Integer id);
}