package com.devandy.studypedia.user;

import com.devandy.studypedia.utils.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "user/signin";
    }

    @PostMapping("/user/loginProc")
    public String loginProcess(String email, String password, HttpSession session) {
        User loginUser = userRepository.findByEmail(email);
        if(userService.validationLogin(email, password)) {
            session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, loginUser);
            System.out.println("로그인 !! : "+email);
            return "redirect:/";
        } else {
            return "user/signin";
        }
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "user/signup";
    }

    @PostMapping("/user/signupProc")
    public String signUpProcess(User user) {
        userService.createUser(user);
        System.out.println("회원가입!!");
        System.out.println("user : "+user.getEmail());
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping(value = "/user/emailChk", method = RequestMethod.POST)
    public boolean emailChk(@RequestBody String email) {
        return userService.emailValidation(email);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        User user = HttpSessionUtils.getUserFromSession(session);
        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
        System.out.println("로그아웃!! "+user.getEmail());
        return "redirect:/";
    }
}
