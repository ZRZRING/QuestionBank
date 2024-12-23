package ldu.questionbank.repo;

import ldu.questionbank.entity.Admin;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepo {
    JdbcTemplate jdbcTemplate;

    public AdminRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Admin> getAllAdmins() {
        String sql = "SELECT * FROM admin";
        RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<>(Admin.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Admin getAdminById(Integer id) {
        String sql = "SELECT * FROM admin WHERE id = ?";
        RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<>(Admin.class);
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }
}
