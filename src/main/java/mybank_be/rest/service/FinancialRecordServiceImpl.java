package mybank_be.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybank_be.rest.dao.FinancialRecordDao;
import mybank_be.rest.entity.FinancialRecord;
import mybank_be.rest.entity.Wallet;

@Service
public class FinancialRecordServiceImpl implements FinancialRecordService {
    @Autowired
    private FinancialRecordDao dao;

    @Autowired
    private WalletService walletService;

    @Override
    public List<FinancialRecord> findAll() {
        return dao.findAll();
    }

    @Override
    public FinancialRecord findById(Long id) {
        return dao.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public FinancialRecord save(Long walletId, FinancialRecord financialRecord) {
        Wallet wallet = walletService.findById(walletId);
        financialRecord.setWallet(wallet);
        return dao.save(financialRecord);
    }

    @Override
    public FinancialRecord update(Long id, Long walletId, FinancialRecord financialRecordDetails) {
        FinancialRecord financialRecord = findById(id);

        // Update fields
        financialRecord.setDescription(financialRecordDetails.getDescription());
        financialRecord.setAmount(financialRecordDetails.getAmount());
        financialRecord.setDate(financialRecordDetails.getDate());
        financialRecord.setType(financialRecordDetails.getType());
        financialRecord.setDateTime(financialRecordDetails.getDateTime());
        financialRecord.setCategory(financialRecordDetails.getCategory());

        // Update wallet association if walletId is provided
        if (walletId != null) {
            Wallet wallet = walletService.findById(walletId);
            financialRecord.setWallet(wallet);
        }

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