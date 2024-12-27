package ldu.questionbank.service;

import ldu.questionbank.dao.TeacherDao;
import ldu.questionbank.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    TeacherDao teacherDao;

    public TeacherService(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    public List<Teacher> findTeachersLike(String username) {
        return teacherDao.findTeachersLike(username);
    }

    public Teacher getTeacherById(Integer id) {
        return teacherDao.getTeacherById(id);
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    public void deleteTeacher(Integer id) {
        teacherDao.deleteTeacher(id);
    }

    public void updatePassword(Integer id, String password) {
        teacherDao.updatePassword(id, password);
    }
}
