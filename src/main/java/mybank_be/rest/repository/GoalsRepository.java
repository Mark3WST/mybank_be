package mybank_be.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mybank_be.rest.entity.Goals;

public interface GoalsRepository extends JpaRepository<Goals, Long> {

}
