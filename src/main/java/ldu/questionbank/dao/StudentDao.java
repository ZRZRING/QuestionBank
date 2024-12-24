package ldu.questionbank.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


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
}
