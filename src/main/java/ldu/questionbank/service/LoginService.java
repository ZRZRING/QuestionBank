package ldu.questionbank.service;

import ldu.questionbank.dao.AdminDao;
import ldu.questionbank.dao.StudentDao;
import ldu.questionbank.dao.TeacherDao;
import ldu.questionbank.dto.LoginRequest;
import ldu.questionbank.entity.Admin;
import ldu.questionbank.entity.Student;
import ldu.questionbank.entity.Teacher;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    AdminDao adminDao;
    TeacherDao teacherDao;
    StudentDao studentDao;

    public LoginService(AdminDao adminDao, TeacherDao teacherDao, StudentDao studentDao) {
        this.adminDao = adminDao;
        this.teacherDao = teacherDao;
        this.studentDao = studentDao;
    }

    private boolean adminLogin(Admin admin) {
        Admin checkAdmin = adminDao.getAdminByUsername(admin.getUsername());
        return admin.getPassword().equals(checkAdmin.getPassword());
    }

    private boolean teacherLogin(Teacher teacher) {
        Admin checkAdmin = adminDao.getAdminByUsername(teacher.getUsername());
        return teacher.getPassword().equals(checkAdmin.getPassword());
    }

    private boolean studentLogin(Student student) {
        Admin checkAdmin = adminDao.getAdminByUsername(student.getUsername());
        return student.getPassword().equals(checkAdmin.getPassword());
    }

    public boolean login(LoginRequest loginRequest) {
        if (loginRequest.getRole().equals("admin")) {
            Admin admin = new Admin();
            admin.setUsername(loginRequest.getUsername());
            admin.setPassword(loginRequest.getPassword());
            loginRequest.setId(admin.getId());
            return adminLogin(admin);
        }
        if (loginRequest.getRole().equals("teacher")) {
            Teacher teacher = new Teacher();
            teacher.setUsername(loginRequest.getUsername());
            teacher.setPassword(loginRequest.getPassword());
            loginRequest.setId(teacher.getId());
            return teacherLogin(teacher);
        }
        if (loginRequest.getRole().equals("student")) {
            Student student = new Student();
            student.setUsername(loginRequest.getUsername());
            student.setPassword(loginRequest.getPassword());
            loginRequest.setId(student.getId());
            return studentLogin(student);
        }
        return false;
    }
}
