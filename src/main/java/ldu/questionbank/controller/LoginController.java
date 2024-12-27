package ldu.questionbank.controller;

import ldu.questionbank.config.Result;
import ldu.questionbank.dto.LoginRequest;
import ldu.questionbank.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {
    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        boolean result = loginService.login(loginRequest);
        System.out.println(result);
        if (result) {
            return Result.success(loginRequest);
        } else {
            return Result.error("用户名或密码错误");
        }
    }
}
