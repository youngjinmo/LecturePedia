package com.devandy.studypedia.lecture;

import com.devandy.studypedia.user.User;
import com.devandy.studypedia.user.UserService;
import com.devandy.studypedia.utils.HttpSessionUtils;
import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private UserService userService;

    @GetMapping("/lecture/register")
    public String registerFormLecture(HttpSession session) {
        if(!HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/login";
        }
        return "lecture/addLecture";
    }

    @PostMapping("/lecture/registering")
    public String registrationLecture(RequestSaveLectureDto requestSaveLectureDto, HttpSession session) {
        User author = HttpSessionUtils.getUserFromSession(session);
        lectureService.addLecture(requestSaveLectureDto, author.getId());
        return "redirect:/lecture/list";
    }

    @GetMapping("/lecture/{lectureId}")
    public String getLecture(@PathVariable Long lectureId, Model model, HttpSession session) {
        if(!HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/login";
        }
        if(!userService.hasAuthority(lectureId, session)) {
            lectureService.increaseViewCount(lectureId);
        }
        Lecture targetLecture = lectureService.getLecture(lectureId);
        model.addAttribute("lecture",targetLecture);
        model.addAttribute("authority", true);
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

    @GetMapping("/lecture/list")
    public String retrievePosts(final @PageableDefault(size = 5, page = 0) Pageable pageable, Model model) {
        if(lectureService.isEmptyList()) {
            return "redirect:/lecture/register";
        }

        Page<Lecture> lecturesForPage = lectureService.getLecturesByPagination(pageable);
        List<Lecture> lectures = lecturesForPage.getContent();
        model.addAttribute("lectures", lectures);

        long totalCount = lectureService.getLecturesTotalCount();
        model.addAttribute("totalCount",totalCount);
        return "lecture/listLecture";
    }
}
