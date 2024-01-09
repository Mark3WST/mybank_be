package mybank_be.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybank_be.rest.dao.ExpenseDao;
import mybank_be.rest.entity.Expense;
import mybank_be.rest.exception.ResourceNotFoundException;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseDao expenseDao;

    @Override
    public List<Expense> findAllExpenses() {
        return expenseDao.findAllExpenses();
    }

    @Override
    public Expense addExpense(Expense expense) {
        return expenseDao.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, Expense expenseDetails) {
        Expense expense = expenseDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found for this id :: " + id));

        expense.setDescription(expenseDetails.getDescription());
        expense.setAmount(expenseDetails.getAmount());
        expense.setDate(expenseDetails.getDate());
        return expenseDao.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found for this id :: " + id));
        expenseDao.delete(expense);
    }

    @Override
    // You might want to implement a method to find expense by ID
    public Expense getExpenseById(Long id) {
        return expenseDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found for this id :: " + id));
    }
}