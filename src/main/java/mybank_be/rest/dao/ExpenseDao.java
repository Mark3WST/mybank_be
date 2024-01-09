package mybank_be.rest.dao;

import java.util.List;
import java.util.Optional;

import mybank_be.rest.entity.Expense;

public interface ExpenseDao {
    List<Expense> findAllExpenses();

    Optional<Expense> findById(Long id);

    Expense save(Expense expense);

    void delete(Expense expense);
}
