package ldu.questionbank.student;

import ldu.questionbank.dao.StudentDao;
import ldu.questionbank.entity.Bank;
import ldu.questionbank.entity.StudentBank;
import ldu.questionbank.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentServiceTest {
        @Autowired
        private StudentService studentService;
        @Autowired
        private StudentDao studentDao;
        @Test
        public void test(){
            List<Bank> res = studentService.findAllBank();
            System.out.println(res.size());
            for (Bank bank : res) {
                System.out.println(bank.toString());
            }
        }

        @Test
    public void test1(){
            Bank bank = new Bank();
            bank.setId(1);
            System.out.println(bank.getId());
        }

        @Test
    public void test2(){
            studentService.addStudentBanks(1,1);
            List<StudentBank> studentBanks = studentService.findAllStudentBank();
            for (StudentBank studentBank : studentBanks) {
                System.out.println(studentBank.toString());
            }
        }





}