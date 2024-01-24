
package mybank_be.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mybank_be.rest.entity.FinancialRecord;
import mybank_be.rest.service.FinancialRecordService;

@RestController
@RequestMapping("/financialRecords")
public class FinancialRecordController {
    @Autowired
    private FinancialRecordService service;

    @GetMapping
    public List<?> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        FinancialRecord record = service.findById(id);
        return ResponseEntity.ok(record);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestParam Long walletId, @RequestBody FinancialRecord financialRecord) {
        FinancialRecord newRecord = service.save(walletId, financialRecord);
        return ResponseEntity.ok(newRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
            @RequestParam(required = false) Long walletId,
            @RequestBody FinancialRecord financialRecord) {
        FinancialRecord updatedRecord = service.update(id, walletId, financialRecord);
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/totalIncome")
    public ResponseEntity<Double> getTotalIncome() {
        return ResponseEntity.ok(service.getTotalIncome());
    }

    @GetMapping("/totalExpenses")
    public ResponseEntity<Double> getTotalExpenses() {
        return ResponseEntity.ok(service.getTotalExpenses());
    }

    @GetMapping("/netAmount")
    public ResponseEntity<Double> getNetAmount() {
        return ResponseEntity.ok(service.getNetAmount());
    }
}
