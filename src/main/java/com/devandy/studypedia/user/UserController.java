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

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if(HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/";
        }
        return "user/userLogin";
    }

    @PostMapping("/user/loginProc")
    public String loginProcess(String email, HttpSession session) {
        User loginUser = userRepository.findByEmail(email);
        if(loginUser.getRole().equals(Role.ADMIN)) {
            session.setAttribute(HttpSessionUtils.ADMIN_SESSION_KEY, loginUser);
        }
        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, loginUser);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signupPage(HttpSession session) {
        if(HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/";
        }
        return "user/userCreate";
    }

    @PostMapping("/user/signupProc")
    public String signUpProcess(RequestSaveUserDto requestSaveUserDto) {
        userService.createUser(requestSaveUserDto);
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping(value = "/user/emailChk", method = RequestMethod.POST)
    public boolean isEmailAvailableToCreate(@RequestBody String email) {
        return userService.validationEmail(email);
    }

    @ResponseBody
    @RequestMapping(value = "/user/passwordChk", method = RequestMethod.POST)
    public boolean validationPasswordByLogin(@RequestParam String email, @RequestParam String password) {
        return userService.validationPasswordByLogin(email, password);
    }

    @GetMapping("/user/{id}")
    public String userProfile(@PathVariable Long id, Model model, HttpSession session) {
        if(userService.isAvaliableUpdateUser(id, session)) {
            User user = HttpSessionUtils.getUserFromSession(session);
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

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id, HttpSession session) {
        if(!HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/";
        }
        User currentUser = HttpSessionUtils.getUserFromSession(session);
        if(currentUser.getId().equals(id)) {
            session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
            userService.deleteUser(id);
            return "redirect:/";
        }
        if(HttpSessionUtils.hasRoleLoginUser(session, Role.ADMIN)) {
            userService.deleteUser(id);
            return "redirect:/user/list";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/list")
    public String userList(HttpSession session, Model model) {
        if(!HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/login";
        }
        if(HttpSessionUtils.hasRoleLoginUser(session, Role.ADMIN)) {
            model.addAttribute("users",userService.getAllUsers());
            return "user/userList";
        }
        return "redirect:/";
    }
}
