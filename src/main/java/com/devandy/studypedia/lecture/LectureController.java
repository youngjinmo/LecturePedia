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

    @GetMapping("/lecture/register")
    public String registerFormLecture(HttpSession session) {
        if(session.getAttribute(HttpSessionUtils.USER_SESSION_KEY)==null) {
            return "redirect:/login";
        }
        return "lecture/addLecture";
    }

    @PostMapping("/lecture/registering")
    public String registrationLecture(RequestSaveLectureDto requestSaveLectureDto, HttpSession session) {
        User author = (User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
        lectureService.addLecture(requestSaveLectureDto, author.getId());
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
            return "redirect:/login";
        }
        Lecture lecture = lectureService.getLecture(id);
        model.addAttribute("lecture",lecture);

        User currentUser = (User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
        if(currentUser!=null && lectureService.hasAuthority(id, currentUser.getId())){
            model.addAttribute("authority", true);
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
        Long currentUserId = ((User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY)).getId();
        if(lectureService.hasAuthority(id, currentUserId)) {
            lectureService.deleteLecture(id);
            return "redirect:/lecture/list";
        }
        return "redirect:/";
    }
}
