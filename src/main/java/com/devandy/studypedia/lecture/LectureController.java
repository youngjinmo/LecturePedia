package com.devandy.studypedia.lecture;

import com.devandy.studypedia.utils.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private HttpSession session;

    @GetMapping("/lecture/register")
    public String getLecturePage() {
        if(session.getAttribute(HttpSessionUtils.USER_SESSION_KEY)==null) {
            return "redirect:/user/login";
        }
        return "lecture/addLecture";
    }

    @PostMapping("/lecture/registering")
    public String registrationLecture(Lecture lecture) {
        lectureService.postLecture(lecture);
        return "redirect:/";
    }
}
