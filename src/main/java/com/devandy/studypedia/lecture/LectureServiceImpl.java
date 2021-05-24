package com.devandy.studypedia.lecture;

import com.devandy.studypedia.utils.HttpSessionUtils;
import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class LectureServiceImpl implements LectureService{

    @Autowired
    private LectureRepository lectureRepository;

    @Override
    public void addLecture(RequestSaveLectureDto requestSaveLectureDto, Long authorId) {
        requestSaveLectureDto.setAuthor(authorId);
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

    @Override
    public List<Lecture> getLatestAddedLecture(int count) {
        List<Lecture> lectureList = lectureRepository.findAll();
        List<Lecture> getLectures = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            getLectures.add(lectureList.get(lectureList.size()-i));
        }
        return getLectures;
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
