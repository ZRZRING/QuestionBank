package ldu.questionbank.controller;

import ldu.questionbank.entity.Question;
import ldu.questionbank.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // 获取所有问题
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.findAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable int id) {
        Question question = questionService.findQuestionById(id);
        if (question == null) {
            return ResponseEntity.notFound().build();  // 返回404 Not Found
        }
        return ResponseEntity.ok(question);  // 返回200 OK
    }

    @GetMapping("/statement/{statement}")
    public ResponseEntity<List<Question>> getQuestionByStatement(@PathVariable String statement) {
        List<Question> questions = questionService.findQuestionsByStatement(statement);
        if (questions.isEmpty()) {
            return ResponseEntity.noContent().build();  // 返回204 No Content
        }
        return ResponseEntity.ok(questions);  // 返回200 OK
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        questionService.saveQuestion(question);
        return ResponseEntity.ok(question);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable int id, @RequestBody Question question) {
        if (question == null) {
            return ResponseEntity.badRequest().build();  // 返回400 Bad Request
        }

        Question existingQuestion = questionService.findQuestionById(id);
        if (existingQuestion == null) {
            return ResponseEntity.notFound().build();  // 返回404 Not Found
        }

        question.setId(id);
        questionService.updateQuestion(question);
        return ResponseEntity.ok(question);  // 返回200 OK
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable int id) {
        Question existingQuestion = questionService.findQuestionById(id);
        if (existingQuestion == null) {
            return ResponseEntity.notFound().build();  // 返回404 Not Found
        }

        questionService.deleteQuestionById(id);
        return ResponseEntity.noContent().build();  // 返回204 No Content
    }
}