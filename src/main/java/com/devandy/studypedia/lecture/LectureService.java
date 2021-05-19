package com.devandy.studypedia.lecture;

import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface LectureService {
    void addLecture(Lecture lecture);
    Lecture getLecture(Long id);
    void updateLecture(Long id, RequestUpdateLectureDto requestUpdateLectureDto);
    void deleteLecture(Long id);
    boolean validationAuthorization(Lecture lecture, HttpSession session);

    List<Lecture> findAll();
}
