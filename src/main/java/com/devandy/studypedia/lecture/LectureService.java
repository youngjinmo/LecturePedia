package com.devandy.studypedia.lecture;

import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LectureService {
    void addLecture(RequestSaveLectureDto requestSaveLectureDto, Long authorId);
    Lecture getLecture(Long id);
    void updateLecture(Long id, RequestUpdateLectureDto requestUpdateLectureDto);
    void deleteLecture(Long id);
    boolean hasAuthority(Long lectureId, Long currentUserId);
    List<Lecture> getLatestAddedLecture(int count);
    void increaseViewCount(Long id);
    boolean isEmptyList();
    void updateAuthorName(Long authorId);
    List<Lecture> getLecturesMostView();
    Page<Lecture> getLecturesByPagination(Pageable pageable);
    long getLecturesTotalCount();
}
