package mybank_be.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybank_be.rest.dao.ExpenseDao;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseDao expenseDao;

}
