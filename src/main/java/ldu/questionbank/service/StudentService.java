package ldu.questionbank.service;

import ldu.questionbank.dao.StudentDao;
import ldu.questionbank.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能: 定义 service 与 dao 层的交互
 * 作者: Zhouzw
 * 日期: 2024/12/21 20:47
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public void deleteStudentById(Integer id) {
        studentDao.deleteStudentById(id);
    }

    public String getPasswordFromBankById(Integer id){
        return studentDao.getPasswordFromBankById(id);
    }

    public List<Bank> findAllBank(){
        return studentDao.findAllBank();
    }

    public Student getMessageFromStudentsById(Integer id) {
        return studentDao.getMessageFromStudentsById(id);
    }

    public List<StudentBank> findAllStudentBank(){
        return studentDao.findAllStudentBank();
    }

    public List<BankQuestion> findAllBankQuestions() {
        return studentDao.findAllBankQuestions();
    }

    public List<Question> findAllQuestions() {
        return studentDao.findAllQuestions();
    }

    public void deletestudentBankById(Integer id){
        studentDao.deletestudentBankById(id);
    }

    public Question findQUestionById(Integer questionId) {
        return studentDao.findQuestionById(questionId);
    }

    public void addStudentBanks(Integer studentId, Integer bankId) {
        studentDao.addStudentBank(studentId,bankId);
    }

    public List<Bank> fuzzyQueryByBankName(String bankName) {
       return studentDao.fuzzyQueryByBankName(bankName);
    }

    public Bank findBankById(Integer bankId) {
        return studentDao.findBankById(bankId);
    }
}
