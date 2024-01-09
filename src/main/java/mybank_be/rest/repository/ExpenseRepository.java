package mybank_be.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mybank_be.rest.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
