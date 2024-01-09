package mybank_be.rest.service;

import java.util.List;

import mybank_be.rest.entity.Expense;

public interface ExpenseService {

    List<Expense> findAllExpenses();

    Expense addExpense(Expense expense);

    Expense updateExpense(Long id, Expense expenseDetails);

    void deleteExpense(Long id);

    Expense getExpenseById(Long id);
}
