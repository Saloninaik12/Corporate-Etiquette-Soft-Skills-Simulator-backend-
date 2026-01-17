package com.corporate_etiquette_mvp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard/trainer")
@CrossOrigin(origins = "http://localhost:4200") // This allows your Angular app to make requests
public class TrainerDashboardController {

    @GetMapping("/assignments")
    public ResponseEntity<List<Map<String, String>>> getAssignments() {
        // We are now returning a List of Maps to satisfy the *ngFor loop.
        Map<String, String> dummyAssignment1 = Map.of("title", "Assignment 1", "status", "Completed");
        Map<String, String> dummyAssignment2 = Map.of("title", "Assignment 2", "status", "In Progress");
        List<Map<String, String>> assignments = List.of(dummyAssignment1, dummyAssignment2);
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<Map<String, String>>> getAlerts() {
        // Returning a list of dummy alert objects.
        Map<String, String> dummyAlert1 = Map.of("type", "Error", "message", "User failed quiz.");
        Map<String, String> dummyAlert2 = Map.of("type", "Warning", "message", "User needs help.");
        List<Map<String, String>> alerts = List.of(dummyAlert1, dummyAlert2);
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/live-monitoring")
    public ResponseEntity<List<Map<String, String>>> getLiveMonitoringData() {
        // Returning a list of dummy monitoring objects.
        Map<String, String> dummyData1 = Map.of("user", "User A", "activity", "Reading");
        Map<String, String> dummyData2 = Map.of("user", "User B", "activity", "Taking Quiz");
        List<Map<String, String>> monitoringData = List.of(dummyData1, dummyData2);
        return ResponseEntity.ok(monitoringData);
    }

    @GetMapping("/key-stats")
    public ResponseEntity<List<Map<String, String>>> getKeyStats() {
        // Returning a list of dummy key stats objects.
        Map<String, String> stat1 = Map.of("metric", "Average Score", "value", "85%");
        Map<String, String> stat2 = Map.of("metric", "Active Users", "value", "12");
        List<Map<String, String>> keyStats = List.of(stat1, stat2);
        return ResponseEntity.ok(keyStats);
    }
}