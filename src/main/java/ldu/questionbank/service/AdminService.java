package ldu.questionbank.service;

import ldu.questionbank.dao.AdminDao;
import ldu.questionbank.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    AdminDao adminDao;

    public AdminService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public List<Admin> getAllAdmins() {
        return adminDao.getAllAdmins();
    }

    public Admin getAdminById(Integer id) {
        return adminDao.getAdminById(id);
    }
}
