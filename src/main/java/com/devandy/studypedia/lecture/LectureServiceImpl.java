package com.devandy.studypedia.lecture;

import com.devandy.studypedia.user.User;
import com.devandy.studypedia.utils.HttpSessionUtils;
import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService{

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private HttpSession session;

    @Override
    public void addLecture(RequestSaveLectureDto requestSaveLectureDto) {
        User currentUser = (User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
        requestSaveLectureDto.setAuthor(currentUser.getId());
        lectureRepository.save(requestSaveLectureDto.toEntity());
    }

    @Override
    public Lecture getLecture(Long id) {
        if(lectureRepository.findById(id).isPresent()) {
            return lectureRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void updateLecture(Long id, RequestUpdateLectureDto requestUpdateLectureDto) {
        Lecture targetLecture = lectureRepository.findById(id).get();
        targetLecture.setTitle(requestUpdateLectureDto.getTitle());
        targetLecture.setCreator(requestUpdateLectureDto.getCreator());
        targetLecture.setDescription(requestUpdateLectureDto.getDescription());
        targetLecture.setLectureUrl(requestUpdateLectureDto.getLectureUrl());
        lectureRepository.save(targetLecture);
    }

    @Override
    public void deleteLecture(Long id) {
        Lecture targetLecture = lectureRepository.findById(id).get();
        lectureRepository.delete(targetLecture);
    }

    public boolean validationAuthorization(Lecture lecture, HttpSession session) {
        if(HttpSessionUtils.getUserFromSession(session)!=null
            && HttpSessionUtils.getUserFromSession(session).getId().equals(lecture.getAuthor())) {
            return true;
        }
        return false;
    }

    @Override
    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }
}
