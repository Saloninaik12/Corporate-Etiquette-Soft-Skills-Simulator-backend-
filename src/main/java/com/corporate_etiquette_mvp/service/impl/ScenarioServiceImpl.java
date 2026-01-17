package com.corporate_etiquette_mvp.service.impl;

import com.corporate_etiquette_mvp.Dao.ScenarioDao;
import com.corporate_etiquette_mvp.model.Scenario;
import com.corporate_etiquette_mvp.service.ScenarioService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScenarioServiceImpl implements ScenarioService {

    private final ScenarioDao scenarioDao;

    public ScenarioServiceImpl(ScenarioDao scenarioDao) {
        this.scenarioDao = scenarioDao;
    }

    @Override
    public Scenario saveScenario(Scenario scenario) {
        return scenarioDao.save(scenario);
    }

    @Override
    public Scenario createScenario(Scenario scenario) {
        return scenarioDao.save(scenario);
    }

    @Override
    public Scenario getScenarioById(Integer id) {
        return scenarioDao.findById(id).orElse(null);
    }

    @Override
    public Scenario updateScenario(Integer id, Scenario updatedScenario) {
        Scenario scenario = scenarioDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Scenario not found with id " + id));

        scenario.setTitle(updatedScenario.getTitle());
        scenario.setDescription(updatedScenario.getDescription());
        scenario.setUpdatedAt(LocalDateTime.now());
        
        // This line is for setting the difficulty and tags, assuming they exist in your updatedScenario object.
        scenario.setDifficulty(updatedScenario.getDifficulty());
        scenario.setTags(updatedScenario.getTags());

        return scenarioDao.save(scenario);
    }

    @Override
    public List<Scenario> getAllScenarios() {
        return scenarioDao.findAll();
    }

    @Override
    public void deleteScenario(Integer id) {
        scenarioDao.deleteById(id);
    }
}