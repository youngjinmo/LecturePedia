package com.devandy.studypedia.lecture;

import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Qualifier("lectureServiceImpl")
public interface LectureService {
    void addLecture(RequestSaveLectureDto requestSaveLectureDto, Long authorId);
    Lecture getLecture(Long id);
    void updateLecture(Long id, RequestUpdateLectureDto requestUpdateLectureDto);
    void deleteLecture(Long id);
    List<Lecture> getLatestAddedLecture(int count);

    List<Lecture> findAll();
}
