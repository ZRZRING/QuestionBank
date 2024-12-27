package ldu.questionbank.dao;

import ldu.questionbank.entity.Admin;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDao {
    JdbcTemplate jdbcTemplate;

    public AdminDao(JdbcTemplate jdbcTemplate) {
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

    public Admin getAdminByUsername(String username) {
        String sql = "SELECT * FROM admin WHERE username = ?";
        RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<>(Admin.class);
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, rowMapper);
        } catch (Exception e) {
            return null;
        }
    }

    public void addAdmin(Admin admin) {
        String sql = "INSERT INTO admin (username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, admin.getUsername(), admin.getPassword());
    }

    public void updateAdmin(Admin admin) {
        String sql = "UPDATE admin SET username = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, admin.getUsername(), admin.getPassword(), admin.getId());
    }

    public void deleteAdmin(Integer id) {
        String sql = "DELETE FROM admin WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
