package com.devandy.studypedia.web;

import com.devandy.studypedia.lecture.LectureService;
import com.devandy.studypedia.user.User;
import com.devandy.studypedia.utils.HttpSessionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final HttpSession session;

    @Autowired
    private LectureService lectureService;

    @GetMapping(value = {"/","/index","/home"})
    public String home(Model model) {
        if(HttpSessionUtils.isLoginUser(session)) {
            User currentUser = (User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
            model.addAttribute("userName",currentUser.getUserName());
        }
        model.addAttribute("lecturesMostView", lectureService.getLecturesMostView(4));
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "/layout/about";
    }
}
