package ldu.questionbank.studentbytest;

import ldu.questionbank.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {
        private StudentService studentService;
        @Test
        public void test(){
            studentService = new StudentService();
            String res = studentService.getPasswordFromBankById(1);
            System.out.println(res);

        }
}