package com.devandy.studypedia.lecture;

import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;

import java.util.List;

public interface LectureService {
    void addLecture(RequestSaveLectureDto requestSaveLectureDto, Long authorId);
    Lecture getLecture(Long id);
    void updateLecture(Long id, RequestUpdateLectureDto requestUpdateLectureDto);
    void deleteLecture(Long id);
    boolean hasAuthority(Long lectureId, Long currentUserId);
    List<Lecture> getLatestAddedLecture(int count);
    List<Lecture> showLecturesMain();
    void increaseViewCount(Long id);
    List<Lecture> findAll();
}
