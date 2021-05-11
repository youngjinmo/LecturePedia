package com.devandy.studypedia.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/signin")
    public String loginPage() {
        return "user/signin";
    }

    @PostMapping("/user/login")
    public String loginProcess() {
        System.out.println("로그인!!");
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signupPage() {
        System.out.println("회원가입!!");
        return "user/signup";
    }

    @PostMapping("/user/create")
    public String signUpProcess() {
        return "redirect:/";
    }
}
