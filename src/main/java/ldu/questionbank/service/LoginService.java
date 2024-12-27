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

    private Integer adminLogin(Admin admin) {
        Admin checkAdmin = adminDao.getAdminByUsername(admin.getUsername());
        if (admin.getPassword().equals(checkAdmin.getPassword())) {
            return checkAdmin.getId();
        } else {
            return 0;
        }
    }

    private Integer teacherLogin(Teacher teacher) {
        Admin checkTeacher = adminDao.getAdminByUsername(teacher.getUsername());
        if (teacher.getPassword().equals(checkTeacher.getPassword())) {
            return checkTeacher.getId();
        } else {
            return 0;
        }
    }

    private Integer studentLogin(Student student) {
        Admin checkStudent = adminDao.getAdminByUsername(student.getUsername());
        if (student.getPassword().equals(checkStudent.getPassword())) {
            return student.getId();
        } else {
            return 0;
        }
    }

    private Integer teacherRegister(Teacher teacher) {
        Teacher checkTeacher = teacherDao.getTeacherByUsername(teacher.getUsername());
        if (checkTeacher != null) {
            return 0;
        }
        teacher = teacherDao.addTeacher(teacher);
        System.out.println(teacher);
        return teacher.getId();
    }

    private Integer studentRegister(Student student) {
        Student checkStudent = studentDao.getStudentByUsername(student.getUsername());
        if (checkStudent != null) {
            return 0;
        }
        student = studentDao.addStudent(student);
        return student.getId();
    }

    public Integer login(LoginRequest loginRequest) {
        if (loginRequest.getRole().equals("admin")) {
            Admin admin = new Admin();
            admin.setUsername(loginRequest.getUsername());
            admin.setPassword(loginRequest.getPassword());
            return adminLogin(admin);
        } else if (loginRequest.getRole().equals("teacher")) {
            Teacher teacher = new Teacher();
            teacher.setUsername(loginRequest.getUsername());
            teacher.setPassword(loginRequest.getPassword());
            return teacherLogin(teacher);
        } else if (loginRequest.getRole().equals("student")) {
            Student student = new Student();
            student.setUsername(loginRequest.getUsername());
            student.setPassword(loginRequest.getPassword());
            return studentLogin(student);
        }
        return 0;
    }

    public Integer register(LoginRequest loginRequest) {
        if (loginRequest.getRole().equals("teacher")) {
            Teacher teacher = new Teacher();
            teacher.setUsername(loginRequest.getUsername());
            teacher.setPassword(loginRequest.getPassword());
            return teacherRegister(teacher);
        } else if (loginRequest.getRole().equals("student")) {
            Student student = new Student();
            student.setUsername(loginRequest.getUsername());
            student.setPassword(loginRequest.getPassword());
            return studentRegister(student);
        }
        return 0;
    }
}
