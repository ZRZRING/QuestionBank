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
        String sql = "SELECT * FROM question WHERE id = ?";
        RowMapper<Question> rowMapper = new BeanPropertyRowMapper<>(Question.class);
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    public List<Question> findByStatement(String statement) {
        String sql = "SELECT * FROM question WHERE statement LIKE ?";
        RowMapper<Question> rowMapper = new BeanPropertyRowMapper<>(Question.class);
        return jdbcTemplate.query(sql, rowMapper, "%" + statement + "%");
    }

    public void save(Question question) {
        String sql = "INSERT INTO question (statement, options, answers, created_by) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, question.getStatement(), question.getOptions(), question.getAnswers(), question.getCreatedBy());
    }

    public void deleteById(Integer id) {
        String sql = "DELETE FROM question WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Question question) {
        String sql = "UPDATE question SET statement = ?, options = ?, answers = ?, createdBy = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                question.getStatement(),
                question.getOptions(),
                question.getAnswers(),
                question.getCreatedBy(),
                question.getId());
    }

}