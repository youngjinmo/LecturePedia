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
        User loginedUser = (User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
        if(loginedUser != null) {
            model.addAttribute("userName",loginedUser.getUserName());
        }
        model.addAttribute("latestLectures", lectureService.showLecturesMain());
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "/layout/about";
    }
}
