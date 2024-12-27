package ldu.questionbank.dao;

import ldu.questionbank.entity.BankQuestion;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankQuestionDao {
    private JdbcTemplate jdbcTemplate;

    public BankQuestionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BankQuestion> getBankQuestions() {
        String sql = "select * from bank_question";
        RowMapper<BankQuestion> rowMapper = new BeanPropertyRowMapper<>(BankQuestion.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<BankQuestion> getBankQuestionsByBankId(int bankId) {
        String sql = "select * from bank_question where bank_id=?";
        RowMapper<BankQuestion> rowMapper = new BeanPropertyRowMapper<>(BankQuestion.class);
        return jdbcTemplate.query(sql, rowMapper, bankId);
    }

    public List<BankQuestion> getBankQuestionsByQuestionId(int questionId) {
        String sql = "select * from bank_question where question_id=?";
        RowMapper<BankQuestion> rowMapper = new BeanPropertyRowMapper<>(BankQuestion.class);
        return jdbcTemplate.query(sql, rowMapper, questionId);
    }

    public void add(BankQuestion bankQuestion) {
        String sql = "insert into bank_question(bank_id,question_id) values(?,?)";
        jdbcTemplate.update(sql,bankQuestion.getBankId(),bankQuestion.getQuestionId());
    }

    public void delete(int id) {
        String sql = "delete from bank_question where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
