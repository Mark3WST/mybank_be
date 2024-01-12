// FinancialRecordRepository.java
package mybank_be.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mybank_be.rest.entity.FinancialRecord;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
}
