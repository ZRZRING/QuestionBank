package ldu.questionbank.dao;

import ldu.questionbank.entity.Bank;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankDao {
    private final JdbcTemplate jdbcTemplate;

    public BankDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bank> findAll() {
        String sql = "select * from bank";
        RowMapper<Bank> rowMapper = new BeanPropertyRowMapper<>(Bank.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Bank findById(int id) {
        String sql = "select * from bank where id = ?";
        RowMapper<Bank> rowMapper = new BeanPropertyRowMapper<>(Bank.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public void save(Bank bank) {
        String sql = "insert into bank(name,password,description,createdBy) values(?,?,?,?)";
        jdbcTemplate.update(sql, bank.getName(), bank.getPassword(), bank.getDescription(), bank.getCreatedBy());
    }

    public void update(Bank bank) {
        String sql = "update bank set name=?,password=?,description=? where id=?";
        jdbcTemplate.update(sql, bank.getName(), bank.getPassword(), bank.getDescription(), bank.getId());
    }

    public void delete(int id) {
        String sql = "delete from bank where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
