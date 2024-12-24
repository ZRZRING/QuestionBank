package ldu.questionbank.repo;

import ldu.questionbank.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class QuestionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Question findById(Integer id) {
        String sql = "SELECT * FROM qbank.question WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setStatement(rs.getString("statement"));
                question.setOptions(rs.getString("options"));
                question.setAnswers(rs.getString("answers"));
                question.setCreatedBy(rs.getInt("created_by"));
                return question;
            }
        });
    }

    public List<Question> findAll() {
        String sql = "SELECT * FROM qbank.question";
        return jdbcTemplate.query(sql, new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setStatement(rs.getString("statement"));
                question.setOptions(rs.getString("options"));
                question.setAnswers(rs.getString("answers"));
                question.setCreatedBy(rs.getInt("created_by"));
                return question;
            }
        });
    }

}