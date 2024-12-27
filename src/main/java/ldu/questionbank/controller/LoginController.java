package ldu.questionbank.controller;

import ldu.questionbank.config.Result;
import ldu.questionbank.dto.LoginRequest;
import ldu.questionbank.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/api")
public class LoginController {
    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        Integer result = loginService.login(loginRequest);
        System.out.println(result);
        System.out.println(loginRequest);
        if (!result.equals(0)) {
            return Result.success(result);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody LoginRequest loginRequest) {
        Integer result = loginService.register(loginRequest);
        System.out.println(result);
        System.out.println(loginRequest);
        if (!result.equals(0)) {
            return Result.success(result);
        } else {
            return Result.error("用户名重复或系统错误");
        }
    }
}
