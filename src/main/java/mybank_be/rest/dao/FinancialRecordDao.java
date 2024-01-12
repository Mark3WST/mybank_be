package mybank_be.rest.dao;

import java.util.List;
import java.util.Optional;

import mybank_be.rest.entity.FinancialRecord;

public interface FinancialRecordDao {
    List<FinancialRecord> findAll();

    Optional<FinancialRecord> findById(Long id);

    FinancialRecord save(FinancialRecord financialRecord);

    void delete(FinancialRecord financialRecord);
}
