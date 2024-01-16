package mybank_be.rest.service;

import java.util.List;

import mybank_be.rest.entity.Goals;

public interface GoalsService {
    Goals createGoals(Goals goals);

    List<Goals> getAllGoals();

    Goals updateGoals(Long id, Goals goalsDetails);

    void deleteGoals(Long id);
}
