package com.devandy.studypedia.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String loginPage() {
        return "user/signin";
    }

    @PostMapping("/user/login")
    public String loginProcess(User user) {
        System.out.println("로그인!!");
        System.out.println("user : "+user.toString());
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "user/signup";
    }

    @PostMapping("/user/create")
    public String signUpProcess(User user) {
        userService.createUser(user);
        System.out.println("회원가입!!");
        System.out.println("user : "+user.toString());
        return "redirect:/signin";
    }

    @ResponseBody
    @RequestMapping(value = "/user/emailChk", method = RequestMethod.POST)
    public boolean emailChk(@RequestBody String email) {
        return userService.emailValidation(email);
    }
}
