package ldu.questionbank.controller;

import ldu.questionbank.service.AdminService;
import ldu.questionbank.entity.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    AdminService adminService;

    public AdminController(AdminService adminService, JdbcTemplate jdbcTemplate) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/getAdminById/{id}")
    public Admin getAdminById(@PathVariable(value="id") Integer id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/addAdmin")
    public void addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
    }

    @PostMapping("/updateAdmin/{id}")
    public void updateAdmin(@RequestBody Admin admin, @PathVariable Integer id) {
        adminService.updateAdmin(admin);
    }

    @DeleteMapping("/deleteAdmin")
    public void deleteAdminById(@PathVariable Integer id) {
        adminService.deleteAdmin(id);
    }
}
