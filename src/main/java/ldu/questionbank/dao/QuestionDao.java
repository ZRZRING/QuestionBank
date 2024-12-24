package ldu.questionbank.dao;

import ldu.questionbank.entity.Question;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao {
    private final JdbcTemplate jdbcTemplate;

    public QuestionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Question> findAll() {
        String sql = "SELECT * FROM question";
        RowMapper<Question> rowMapper = new BeanPropertyRowMapper<>(Question.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Question findById(Integer id) {
        String sql = "SELECT * FROM admin WHERE id = ?";
        RowMapper<Question> rowMapper = new BeanPropertyRowMapper<>(Question.class);
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }
}