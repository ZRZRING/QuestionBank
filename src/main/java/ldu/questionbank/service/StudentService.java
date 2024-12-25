package ldu.questionbank.service;

import ldu.questionbank.dao.StudentDao;
import ldu.questionbank.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能: 定义 service 与 dao 层的交互
 * 作者: Zhouzw
 * 日期: 2024/12/21 20:47
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;


    /**
     * 根据id 返回题库密码
     * @param id
     * @return
     */
    public String getPasswordFromBankById(Integer id){
        return studentDao.getPasswordFromBankById(id);
    }

    public List<Bank> findAllBank(){
        return studentDao.findAllBank();
    }

}
