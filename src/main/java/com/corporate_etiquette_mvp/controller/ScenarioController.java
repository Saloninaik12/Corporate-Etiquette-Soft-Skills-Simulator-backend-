package com.corporate_etiquette_mvp.controller;

import com.corporate_etiquette_mvp.model.Scenario;
import com.corporate_etiquette_mvp.model.User;
import com.corporate_etiquette_mvp.service.ScenarioService;
import com.corporate_etiquette_mvp.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scenarios")
@CrossOrigin(origins = "http://localhost:4200")
public class ScenarioController {

    private final ScenarioService scenarioService;
    private final UserDao userDao;

    @Autowired
    public ScenarioController(ScenarioService scenarioService, UserDao userDao) {
        this.scenarioService = scenarioService;
        this.userDao = userDao;
    }

    @PostMapping
    public ResponseEntity<Scenario> createScenario(@RequestBody Scenario scenario) {
        // Fetch the User object from the database using the UserDao
        // We will fetch the user with ID 1, as confirmed by your table data
        User user = userDao.findById(1).orElseThrow(() -> new RuntimeException("User not found with ID 1"));

        // Set the fetched User object on the scenario
        scenario.setCreatedBy(user);

        // Save the scenario
        Scenario savedScenario = scenarioService.saveScenario(scenario);
        return ResponseEntity.ok(savedScenario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scenario> updateScenario(@PathVariable Integer id, @RequestBody Scenario updatedScenario) {
        Scenario scenario = scenarioService.updateScenario(id, updatedScenario);
        return ResponseEntity.ok(scenario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scenario> getScenario(@PathVariable Integer id) {
        Scenario scenario = scenarioService.getScenarioById(id);
        return ResponseEntity.ok(scenario);
    }

    @GetMapping
    public ResponseEntity<List<Scenario>> getAllScenarios() {
        List<Scenario> scenarios = scenarioService.getAllScenarios();
        return ResponseEntity.ok(scenarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScenario(@PathVariable Integer id) {
        scenarioService.deleteScenario(id);
        return ResponseEntity.noContent().build();
    }
}