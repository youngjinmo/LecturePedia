package com.devandy.studypedia.user;

import com.devandy.studypedia.utils.HttpSessionUtils;
import com.devandy.studypedia.web.dto.user.RequestSaveUserDto;
import com.devandy.studypedia.web.dto.user.RequestUpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/login")
    public String loginPage() {
        return "user/userLogin";
    }

    @PostMapping("/user/loginProc")
    public String loginProcess(String email, String password, HttpSession session) {
        User loginUser = userRepository.findByEmail(email);
        if(userService.validationLogin(email, password)) {
            session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, loginUser);
            System.out.println("로그인 !! : "+email);
            System.out.println(loginUser.getLastModifiedDate());
            return "redirect:/";
        } else {
            return "redirect:/user/userLogin";
        }
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "user/userCreate";
    }

    @PostMapping("/user/signupProc")
    public String signUpProcess(RequestSaveUserDto requestSaveUserDto) {
        userService.createUser(requestSaveUserDto);
        System.out.println("회원가입!! : user.getEmail()");
        return "redirect:/user/login";
    }

    @ResponseBody
    @RequestMapping(value = "/user/emailChk", method = RequestMethod.POST)
    public boolean emailChk(@RequestBody String email) {
        return userService.emailValidation(email);
    }

    @GetMapping("/user/{id}")
    public String userProfile(@PathVariable Long id, Model model, HttpSession session) {
        if(userService.isAvaliableUpdateUser(id, session)) {
            User user = (User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
            model.addAttribute("user",user);
            model.addAttribute("id",user.getId());
            return "user/userUpdate";
        }
        return "redirect:/";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable Long id, RequestUpdateUserDto requestUpdateUserDto, HttpSession session) {
        userService.updateUser(id, requestUpdateUserDto);
        User user = userRepository.findById(id).get();
        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY,user);
        return "redirect:/";
    }
}
