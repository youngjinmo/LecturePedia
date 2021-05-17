package com.devandy.studypedia.lecture;

import javax.servlet.http.HttpSession;

public interface LectureService {
    void postLecture(Lecture lecture);
    Lecture getLecture(Long id);
    void updateLecture(Long id, Lecture lecture);
    void deleteLecture(Long id);
    boolean validationAuthorization(Lecture lecture, HttpSession session);
}
