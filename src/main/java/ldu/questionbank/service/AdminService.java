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

    public void addAdmin(Admin admin) {
        adminDao.addAdmin(admin);
    }

    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    public void deleteAdmin(Integer id) {
        adminDao.deleteAdmin(id);
    }
}
