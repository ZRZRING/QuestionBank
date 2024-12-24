package ldu.questionbank.controller;

import ldu.questionbank.service.AdminService;
import ldu.questionbank.entity.Admin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/getAdminById/{id}")
    public Admin getAdminById(@PathVariable(value="id") Integer id) {
        return adminService.getAdminById(id);
    }
}
