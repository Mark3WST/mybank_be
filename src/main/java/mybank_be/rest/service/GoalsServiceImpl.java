package mybank_be.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybank_be.rest.dao.GoalsDao;
import mybank_be.rest.entity.Goals;

@Service
public class GoalsServiceImpl implements GoalsService {

    @Autowired
    private GoalsDao goalsDao;

    @Override
    public Goals createGoals(Goals goals) {
        return goalsDao.save(goals);
    }

    @Override
    public List<Goals> getAllGoals() {
        return goalsDao.findAll();
    }

    @Override
    public Goals updateGoals(Long id, Goals goalsDetails) {
        Goals goals = goalsDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Goals not found for this id :: " + id));

        goals.setName(goalsDetails.getName());
        goals.setTargetAmount(goalsDetails.getTargetAmount());
        goals.setCurrentAmount(goalsDetails.getCurrentAmount());
        return goalsDao.save(goals);
    }

    @Override
    public void deleteGoals(Long id) {
        Goals goals = goalsDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Goals not found for this id :: " + id));
        goalsDao.delete(goals);
    }
}
