package ldu.questionbank.controller;

import ldu.questionbank.entity.BankQuestion;
import ldu.questionbank.service.BankQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qBanks")
public class BankQuestionController {
    private final BankQuestionService bankQuestionService;

    public BankQuestionController(BankQuestionService bankQuestionService) {
        this.bankQuestionService = bankQuestionService;
    }

    @GetMapping
    public ResponseEntity<List<BankQuestion>> getAllBankQuestions() {
        List<BankQuestion> qbanks = bankQuestionService.getBankQuestions();
        return ResponseEntity.ok(qbanks);  // 返回200 OK
    }

    @GetMapping("/bank/{bank_id}")
    public ResponseEntity<List<BankQuestion>> getBankQuestionsByBankId(@PathVariable int bank_id) {
        List<BankQuestion> qbanks = bankQuestionService.getBankQuestionsByBankId(bank_id);
        return ResponseEntity.ok(qbanks);  // 返回200 OK
    }

    @GetMapping("/question/{question_id}")
    public ResponseEntity<List<BankQuestion>> getBankQuestionById(@PathVariable int question_id) {
        List<BankQuestion> qbanks = bankQuestionService.getBankQuestionsByQuestionId(question_id);
        return ResponseEntity.ok(qbanks);  // 返回200 OK
    }

    @PostMapping
    public ResponseEntity<BankQuestion> createBankQuestion(@RequestBody BankQuestion bankQuestion) {
        if (bankQuestion == null) {
            return ResponseEntity.badRequest().build();  // 返回400 Bad Request
        }
        bankQuestionService.addBankQuestion(bankQuestion);
        return ResponseEntity.status(HttpStatus.CREATED).body(bankQuestion);  // 返回201 Created
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBankQuestion(@PathVariable int id) {
        BankQuestion existingBankQuestion = bankQuestionService.getBankQuestionsByQuestionId(id).stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);

        if (existingBankQuestion == null) {
            return ResponseEntity.notFound().build();  // 返回404 Not Found
        }

        bankQuestionService.deleteBankQuestion(id);
        return ResponseEntity.noContent().build();  // 返回204 No Content
    }
}
