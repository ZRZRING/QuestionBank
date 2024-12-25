package ldu.questionbank.dao;

import ldu.questionbank.entity.Bank;
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


}
