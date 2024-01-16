package mybank_be.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import mybank_be.rest.entity.Goals;
import mybank_be.rest.repository.GoalsRepository;

@Repository
@Profile("db")
public class GoalsDaoImpl implements GoalsDao {

    @Autowired
    GoalsRepository goalsRepository;

    @Override
    public Goals save(Goals goals) {
        return goalsRepository.save(goals);
    }

    @Override
    public List<Goals> findAll() {
        return goalsRepository.findAll();
    }

    @Override
    public Optional<Goals> findById(Long id) {
        return goalsRepository.findById(id);
    }

    @Override
    public void delete(Goals goals) {
        goalsRepository.delete(goals);
    }

}
