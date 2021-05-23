package com.devandy.studypedia.lecture;

import com.devandy.studypedia.user.User;
import com.devandy.studypedia.utils.HttpSessionUtils;
import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private HttpSession session;

    @GetMapping("/lecture/register")
    public String registerFormLecture() {
        if(session.getAttribute(HttpSessionUtils.USER_SESSION_KEY)==null) {
            return "redirect:/user/login";
        }
        return "lecture/addLecture";
    }

    @PostMapping("/lecture/registering")
    public String registrationLecture(RequestSaveLectureDto requestSaveLectureDto) {
        lectureService.addLecture(requestSaveLectureDto);
        return "redirect:/lecture/list";
    }

    @GetMapping("/lecture/list")
    public String getLectureList(Model model) {
        if(lectureService.findAll().isEmpty()) {
            return "redirect:/lecture/register";
        }
        model.addAttribute("lectures", lectureService.findAll());
        return "lecture/listLecture";
    }

    @GetMapping("/lecture/{id}")
    public String getLecture(@PathVariable Long id, Model model, HttpSession session) {
        if(session.getAttribute(HttpSessionUtils.USER_SESSION_KEY)==null) {
            return "redirect:/user/login";
        }
        Lecture lecture = lectureService.getLecture(id);
        model.addAttribute("lecture",lecture);

        User currentUser = (User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
        if(currentUser!=null && currentUser.getId().equals(lecture.getAuthor())) {
            model.addAttribute("isCurrentUserAuthor",currentUser);
        }
        return "lecture/detailLecture";
    }

    @GetMapping("/lecture/update/{id}")
    public String updateFormLecture(@PathVariable Long id, Model model) {
        Lecture lecture = lectureService.getLecture(id);
        model.addAttribute("lecture",lecture);
        return "lecture/updateLecture";
    }

    @PostMapping("/lecture/updateProc/{id}")
    public String updateLecture(@PathVariable Long id, RequestUpdateLectureDto requestUpdateLectureDto) {
        lectureService.updateLecture(id, requestUpdateLectureDto);
        return "redirect:/lecture/list";
    }

    @GetMapping("/lecture/delete/{id}")
    public String deleteLecture(@PathVariable Long id, HttpSession session) {
        User currentUser = (User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
        Long authorId = lectureService.getLecture(id).getAuthor();
        if(currentUser.getId().equals(authorId)) {
            lectureService.deleteLecture(id);
            return "redirect:/lecture/list";
        }
        return "redirect:/";
    }
}
