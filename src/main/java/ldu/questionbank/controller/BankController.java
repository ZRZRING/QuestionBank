package ldu.questionbank.controller;

import ldu.questionbank.entity.Bank;
import ldu.questionbank.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public ResponseEntity<List<Bank>> getBanks() {
        List<Bank> banks = bankService.findAllBanks();
        return ResponseEntity.ok(banks);  // 返回200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBank(@PathVariable int id) {
        Bank bank = bankService.findBankById(id);
        if (bank == null) {
            return ResponseEntity.notFound().build();  // 返回404 Not Found
        }
        return ResponseEntity.ok(bank);  // 返回200 OK
    }

    @PostMapping
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        if (bank == null) {
            return ResponseEntity.badRequest().build();  // 返回400 Bad Request
        }
        bankService.addBank(bank);
        return ResponseEntity.status(201).body(bank);  // 返回201 Created
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable int id, @RequestBody Bank bank) {
        if (bank == null) {
            return ResponseEntity.badRequest().build();  // 返回400 Bad Request
        }

        Bank existingBank = bankService.findBankById(id);
        if (existingBank == null) {
            return ResponseEntity.notFound().build();  // 返回404 Not Found
        }

        bank.setId(id);
        bankService.updateBank(bank);
        return ResponseEntity.ok(bank);  // 返回200 OK
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable int id) {
        Bank existingBank = bankService.findBankById(id);
        if (existingBank == null) {
            return ResponseEntity.notFound().build();  // 返回404 Not Found
        }

        bankService.deleteBank(id);
        return ResponseEntity.noContent().build();  // 返回204 No Content
    }
}
