package mybank_be.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mybank_be.rest.entity.Goals;
import mybank_be.rest.service.GoalsService;

@RestController
@RequestMapping("/goals")
public class GoalsController {
    @Autowired
    private GoalsService goalsService;

    @PostMapping
    public ResponseEntity<Goals> createGoals(@RequestBody Goals goals) {
        Goals savedGoals = goalsService.createGoals(goals);
        return ResponseEntity.ok(savedGoals);
    }

    @GetMapping
    public ResponseEntity<List<Goals>> getAllGoalss() {
        return ResponseEntity.ok(goalsService.getAllGoals());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goals> updateGoals(@PathVariable(value = "id") Long goalsId,
            @RequestBody Goals goalsDetails) {
        Goals updatedGoals = goalsService.updateGoals(goalsId, goalsDetails);
        return ResponseEntity.ok(updatedGoals);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoals(@PathVariable(value = "id") Long goalsId) {
        goalsService.deleteGoals(goalsId);
        return ResponseEntity.ok().build();
    }
}
