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

    public List<Student> findAllStudents() {
        String sql = "select * from student";
        RowMapper<Student> rowMapper = BeanPropertyRowMapper.newInstance(Student.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Student addStudent(Student student) {
        String sql = "insert into student(username, password) values(?, ?)";
        jdbcTemplate.update(sql, student.getUsername(), student.getPassword());
        sql = "select * from student where username = ?";
        RowMapper<Student> rowMapper = BeanPropertyRowMapper.newInstance(Student.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, student.getUsername());
    }

    public void deleteStudentById(int id) {
        String sql = "delete from student where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Student getStudentByUsername(String username) {
        String sql = "select * from student where username = ?";
        RowMapper<Student> rowMapper = BeanPropertyRowMapper.newInstance(Student.class);
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, username);
        } catch (Exception e) {
            return null;
        }
    }

    public String getPasswordFromBankById(Integer id) {
        String sql = "select password from bank where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }

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
