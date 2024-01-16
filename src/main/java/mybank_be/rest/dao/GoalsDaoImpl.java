package mybank_be.rest.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("db")
public class GoalsDaoImpl implements GoalsDao {

}
