package ldu.questionbank.controller;

import ldu.questionbank.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能: 定义student 与 前端网络的交互
 * 作者: Zhouzw
 * 日期: 2024/12/21 20:46
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;



}
