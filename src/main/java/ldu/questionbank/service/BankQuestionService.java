package ldu.questionbank.service;

import ldu.questionbank.dao.BankQuestionDao;
import ldu.questionbank.entity.BankQuestion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankQuestionService {
    private BankQuestionDao bankQuestionDao;

    public BankQuestionService(BankQuestionDao bankQuestionDao) {
        this.bankQuestionDao = bankQuestionDao;
    }

    public List<BankQuestion> getBankQuestions() { return bankQuestionDao.getBankQuestions(); }

    public List<BankQuestion> getBankQuestionsByBankId(int bankId) { return bankQuestionDao.getBankQuestionsByBankId(bankId); }

    public List<BankQuestion> getBankQuestionsByQuestionId(int questionId) { return bankQuestionDao.getBankQuestionsByQuestionId(questionId); }

    public void addBankQuestion(BankQuestion bankQuestion) { bankQuestionDao.add(bankQuestion); }

    public void deleteBankQuestion(Integer id) { bankQuestionDao.delete(id); }
}
