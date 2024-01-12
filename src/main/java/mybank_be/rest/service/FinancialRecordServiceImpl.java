package mybank_be.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybank_be.rest.dao.FinancialRecordDao;
import mybank_be.rest.entity.FinancialRecord;

@Service
public class FinancialRecordServiceImpl implements FinancialRecordService {
    @Autowired
    private FinancialRecordDao dao;

    @Override
    public List<FinancialRecord> findAll() {
        return dao.findAll();
    }

    @Override
    public FinancialRecord findById(Long id) {
        return dao.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public FinancialRecord save(FinancialRecord financialRecord) {
        return dao.save(financialRecord);
    }

    @Override
    public void delete(Long id) {
        FinancialRecord record = findById(id);
        dao.delete(record);
    }

    @Override
    public double getTotalIncome() {
        return findAll()
                .stream()
                .filter(record -> "income".equals(record.getType()))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    @Override
    public double getTotalExpenses() {
        return findAll()
                .stream()
                .filter(record -> "expense".equals(record.getType()))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    @Override
    public double getNetAmount() {
        return getTotalIncome() - getTotalExpenses();
    }
}