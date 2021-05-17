package com.devandy.studypedia.lecture;

import com.devandy.studypedia.user.User;
import com.devandy.studypedia.utils.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LectureServiceImpl implements LectureService{

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private HttpSession session;

    @Override
    public void postLecture(Lecture lecture) {
        User sessionedUser = HttpSessionUtils.getUserFromSession(session);
        lecture.setPublisher(sessionedUser.getId());
        lectureRepository.save(lecture);
    }

    @Override
    public Lecture getLecture(Long id) {
        if(lectureRepository.findById(id).isPresent()) {
            return lectureRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void updateLecture(Long id, Lecture lecture) {
        Lecture updateLecture = lectureRepository.findById(id).get();
        lectureRepository.save(updateLecture);
    }

    @Override
    public void deleteLecture(Long id) {
        Lecture targetLecture = lectureRepository.findById(id).get();
        lectureRepository.delete(targetLecture);
    }

    public boolean validationAuthorization(Lecture lecture, HttpSession session) {
        if(HttpSessionUtils.getUserFromSession(session)!=null
            && HttpSessionUtils.getUserFromSession(session).getId().equals(lecture.getPublisher())) {
            return true;
        }
        return false;
    }
}
