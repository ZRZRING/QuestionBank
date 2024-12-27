package ldu.questionbank.dao;

import ldu.questionbank.entity.Teacher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDao {
    JdbcTemplate jdbcTemplate;

    public TeacherDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Teacher> getAllTeachers() {
        String sql = "SELECT * FROM teacher";
        RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper<>(Teacher.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Teacher> findTeachersLike(String username) {
        String sql = "SELECT * FROM teacher WHERE username like ?";
        RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper<>(Teacher.class);
        return jdbcTemplate.query(sql, rowMapper, "%" + username + "%");
    }

    public Teacher getTeacherById(Integer id) {
        String sql = "SELECT * FROM teacher WHERE id = ?";
        RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper<>(Teacher.class);
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    public Teacher getTeacherByUsername(String username) {
        String sql = "SELECT * FROM teacher WHERE username = ?";
        RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper<>(Teacher.class);
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, rowMapper);
        } catch (Exception e) {
            return null;
        }
    }

    public Teacher addTeacher(Teacher teacher) {
        String sql = "INSERT INTO teacher (username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, teacher.getUsername(), teacher.getPassword());
        sql = "SELECT * FROM teacher WHERE username = ?";
        RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper<>(Teacher.class);
        return jdbcTemplate.queryForObject(sql, new Object[]{teacher.getUsername()}, rowMapper);
    }

    public void updateTeacher(Teacher teacher) {
        String sql = "UPDATE teacher SET username = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, teacher.getUsername(), teacher.getPassword(), teacher.getId());
    }

    public void deleteTeacher(Integer id) {
        String sql = "DELETE FROM teacher WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
