package mybank_be.rest.service;

import java.util.List;

import mybank_be.rest.entity.FinancialRecord;

public interface FinancialRecordService {
    List<FinancialRecord> findAll();
    FinancialRecord findById(Long id);
    FinancialRecord save(FinancialRecord financialRecord);
    void delete(Long id);
    double getTotalIncome();
    double getTotalExpenses();
    double getNetAmount();
}