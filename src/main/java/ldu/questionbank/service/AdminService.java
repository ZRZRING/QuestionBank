package ldu.questionbank.service;

import ldu.questionbank.repo.AdminRepo;
import ldu.questionbank.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    AdminRepo adminRepo;

    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.getAllAdmins();
    }

    public Admin getAdminById(Integer id) {
        return adminRepo.getAdminById(id);
    }
}
