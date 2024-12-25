package ldu.questionbank.service;

import ldu.questionbank.dao.BankDao;
import ldu.questionbank.entity.Bank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    private BankDao bankDao;

    public BankService(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    public Bank findBankById(int id) {return bankDao.findById(id);}

    public List<Bank> findAllBanks() {return bankDao.findAll();}

    public void addBank(Bank bank) {bankDao.save(bank);}

    public void updateBank(Bank bank) {bankDao.update(bank);}

    public void deleteBank(int id) {bankDao.delete(id);}
}
