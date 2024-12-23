package ldu.questionbank.studentbytest;


import ldu.questionbank.repo.StudentDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class StudentDaoImplTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentDao studentDao;

    @Test
    void test() {
         String res=studentDao.getPasswordFromBankById(1);
        System.out.println(res);
    }
}