package mybank_be.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import mybank_be.rest.entity.FinancialRecord;
import mybank_be.rest.repository.FinancialRecordRepository;

@Repository
@Profile("db")
public class FinancialRecordDaoImpl implements FinancialRecordDao {
    @Autowired
    private FinancialRecordRepository repository;

    @Override
    public List<FinancialRecord> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<FinancialRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public FinancialRecord save(FinancialRecord financialRecord) {
        return repository.save(financialRecord);
    }

    @Override
    public void delete(FinancialRecord financialRecord) {
        repository.delete(financialRecord);
    }
}