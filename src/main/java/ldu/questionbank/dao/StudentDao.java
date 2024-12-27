package ldu.questionbank.dao;

import ldu.questionbank.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
* 功能:
* 作者: Zhouzw
* 日期: 2024/12/21 21:30
*/

@Repository

public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate ;

    /**
     * 根据id 返回题库密码
     * @param id
     * @return
     */
    public String getPasswordFromBankById(Integer id) {
        String sql = "select password from bank where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }

    /**
     * 查询所有题库信息
     * @return
     */
    public List<Bank> findAllBank() {
        String sql="select * from bank";
        RowMapper<Bank> rowMapper = new BeanPropertyRowMapper<Bank>(Bank.class);
        return jdbcTemplate.query(sql, rowMapper);

    }

    public Student getMessageFromStudentsById(Integer id) {
        String sql = "select * from student where id = ?";
        RowMapper<Student> rowMapper = BeanPropertyRowMapper.newInstance(Student.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<StudentBank> findAllStudentBank() {
        String sql = "select * from student_bank";
        RowMapper<StudentBank> rowMapper = BeanPropertyRowMapper.newInstance(StudentBank.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<BankQuestion> findAllBankQuestions() {
        String sql = "select * from bank_question ";
        RowMapper<BankQuestion> rowMapper = BeanPropertyRowMapper.newInstance(BankQuestion.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Question> findAllQuestions() {
        String sql = "select * from question";
        RowMapper<Question> rowMapper = BeanPropertyRowMapper.newInstance(Question.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void deletestudentBankById(Integer id) {
        String sql ="delete from student_bank where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Question findQuestionById(Integer questionId) {
        String sql = "select * from question where id = ?";
        RowMapper<Question> rowMapper = BeanPropertyRowMapper.newInstance(Question.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, questionId);
    }

    public void addStudentBank(Integer studentId, Integer bankId) {
        String sql = "Insert into student_bank(student_id, bank_id) values(?,?)";
        jdbcTemplate.update(sql, studentId, bankId);
    }

    public List<Bank> fuzzyQueryByBankName(String bankName) {
        String sql="select * from bank where name like ?";
        RowMapper<Bank> rowMapper = BeanPropertyRowMapper.newInstance(Bank.class);
        return jdbcTemplate.query(sql, new Object[]{"%" + bankName + "%"}, rowMapper);
    }

    public Bank findBankById(Integer bankId) {
       String sql = "select * from bank where id = ?";
       RowMapper<Bank> rowMapper = BeanPropertyRowMapper.newInstance(Bank.class);
       return jdbcTemplate.queryForObject(sql, rowMapper, bankId);
    }
}
