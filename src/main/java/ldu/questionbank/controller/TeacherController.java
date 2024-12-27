package ldu.questionbank.controller;

import ldu.questionbank.entity.Teacher;
import ldu.questionbank.service.TeacherService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    TeacherService teacherService;

    public TeacherController(TeacherService teacherService, JdbcTemplate jdbcTemplate) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/findTeachersLike")
    public List<Teacher> findTeachersLike(@RequestParam("username") String username) {
        return teacherService.findTeachersLike(username);
    }

    @GetMapping("/getTeacherById/{id}")
    public Teacher getTeacherById(@PathVariable(value="id") Integer id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/addTeacher")
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @PostMapping("/updateTeacher/{id}")
    public void updateTeacher(@RequestBody Teacher teacher, @PathVariable Integer id) {
        teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/deleteTeacher")
    public void deleteTeacherById(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/updatePassword/{id}")
    public void updatePassword(@PathVariable Integer id, @RequestBody Teacher teacher) {
        String password = teacher.getPassword();
        teacherService.updatePassword(id, password);
    }
}
