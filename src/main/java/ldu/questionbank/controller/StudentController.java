package ldu.questionbank.controller;

import ldu.questionbank.config.Result;
import ldu.questionbank.entity.*;
import ldu.questionbank.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能: 定义student 与 前端网络的交互
 * 作者: Zhouzw
 * 日期: 2024/12/21 20:46
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // 获取所有题库信息
    @GetMapping("/findAllBanks")
    public Result findAllBanks() {
        List<Bank> banks = studentService.findAllBank();
        return Result.success(banks);
    }


   // 通过Id 获取 bank信息
    @GetMapping("/getPasswordFromBanksById/{id}")
    public Result getPasswordFromBanksById(@PathVariable(value = "id") Integer id) {
        String password = studentService.getPasswordFromBankById(id);
        return Result.success(password);
    }

    // 通过Id 获取学生信息
    @PostMapping("/getMessageFromStudentsById/{id}")
    public Result getMessageFromStudentsById(@PathVariable(value = "id") Integer id) {
        Student student = studentService.getMessageFromStudentsById(id);
        return Result.success(student);
    }

    // 通过该学生Id 查询 该学生已经选择的题库信息
    @PostMapping("/getStudentBankByStudentId/{studentId}")
    public Result getStudentBankByStudentId(@RequestParam(value = "studentId") Integer studentId) {
        List<Bank> banks_student = new ArrayList<Bank>();
        List<Integer> ids = new ArrayList<Integer>();
        List<StudentBank> studentBanks = studentService.findAllStudentBank();
        for (StudentBank studentBank : studentBanks) {
            if (studentBank.getStudentId().equals(studentId)) {
                ids.add(studentBank.getBankId());
            }
        }
        List<Bank> banks = studentService.findAllBank();
        for (Bank bank : banks) {
            for (Integer id : ids) {
                if (bank.getId().equals(id)) {
                    banks_student.add(bank);
                }
            }
        }
        return Result.success(banks_student);
    }

    // 通过题库 Id 找到 题库中包含的题目
    @PostMapping("/getBankQuestionByBankId/{bankId}")
    public Result getBankQuestionByBankId(@PathVariable(value = "bankId") Integer bankId) {
        List<Question> res = new ArrayList<Question>();
        List<Integer> ids = new ArrayList<Integer>();
        List<BankQuestion> bankQuestions = studentService.findAllBankQuestions(bankId);
        for (BankQuestion bankQuestion : bankQuestions) {
            if (bankQuestion.getBankId().equals(bankId)) {
                ids.add(bankQuestion.getQuestionId());
            }
        }
        List<Question> questions = studentService.findAllQuestions();
        for(Question question : questions) {
            for(Integer id : ids) {
                if(question.getId().equals(id)) {
                    res.add(question);
                }
            }
        }
        return Result.success(res);
    }

    // 学生通过 id 删除 已选择的题库 id => bankId
    @PostMapping("/deleteStudentBankById/{studentId}/{bankId}")
    public Result deleteStudentBankById(@PathVariable(value = "studentId") Integer studentId, @PathVariable(value = "bankId") Integer bankId) {
          List<StudentBank> studentBanks = studentService.findAllStudentBank();
          List<Integer> ids = new ArrayList<Integer>();
          for (StudentBank studentBank : studentBanks) {
              if (studentBank.getStudentId().equals(studentId) && studentBank.getBankId().equals(bankId)) {
                  ids.add(studentBank.getId());
              }
          }

          for(Integer id : ids) {
              studentService.deletestudentBankById(id);
          }

          return Result.success();
    }

    // 通过题目id 找到 相关题目
    @PostMapping("/findQuestionById")
    public Result findQuestionById(@RequestParam(value = "questionId") Integer questionId) {
        Question   question = studentService.findQUestionById(questionId);
        return Result.success(question);
    }

    // 通过 学生id 和题库id 增加 studentBank
    @PostMapping("/addStudentBank/{studentId}/{bankId}")
    public Result addStudentBank(@PathVariable(value = "studentId") Integer studentId,@PathVariable(value = "bankId") Integer bankId) {
        // 需要去重
        List<StudentBank> studentBanks = studentService.findAllStudentBank();
        for(StudentBank studentBank : studentBanks) {
            if (studentBank.getStudentId().equals(studentId) && studentBank.getBankId().equals(bankId)) {
                return Result.error("插入失败!");
            }
        }
        studentService.addStudentBanks(studentId,bankId);
        return Result.success();
    }
}
