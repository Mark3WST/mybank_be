package mybank_be.rest.dao;

import java.util.List;
import java.util.Optional;

import mybank_be.rest.entity.Goals;

public interface GoalsDao {

    Goals save(Goals goals);

    List<Goals> findAll();

    Optional<Goals> findById(Long id);

    void delete(Goals goals);

}
