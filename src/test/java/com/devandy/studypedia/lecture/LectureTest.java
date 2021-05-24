package com.devandy.studypedia.lecture;

import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LectureTest {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureService lectureService;

    @AfterEach
    void deleteLectureAfterTest() {
        lectureRepository.deleteAll();
    }

    private void addLectureOne(){
        Long authorId = 1L;
        RequestSaveLectureDto requestSaveLectureDto = new RequestSaveLectureDto();
        requestSaveLectureDto.setTitle("스프링 MVC");
        requestSaveLectureDto.setCreator("김영한");
        requestSaveLectureDto.setDescription("Hello world");
        requestSaveLectureDto.setLectureUrl("https://inflearn.com");

        lectureService.addLecture(requestSaveLectureDto, authorId);
    }

    @Test
    @DisplayName("강의 등록 테스트")
    void addLecture() {
        // given
        RequestSaveLectureDto requestSaveLectureDto = new RequestSaveLectureDto();
        requestSaveLectureDto.setTitle("스프링 MVC");
        requestSaveLectureDto.setCreator("김영한");
        requestSaveLectureDto.setDescription("Hello world");
        requestSaveLectureDto.setLectureUrl("https://inflearn.com");

        // when
        lectureService.addLecture(requestSaveLectureDto, 1L);

        // then
        List<Lecture> latestLectures = lectureService.getLatestAddedLecture(1);
        Lecture targetLecture = latestLectures.get(0);
        assertEquals("스프링 MVC",targetLecture.getTitle());
    }

    @Test
    @DisplayName("강의 수정 테스트")
    void updateLecture() {
        // given
        addLectureOne();
        Long targetId = lectureService.getLatestAddedLecture(1).get(0).getId();

        // when
        RequestUpdateLectureDto requestUpdateLectureDto = new RequestUpdateLectureDto();
        requestUpdateLectureDto.setTitle("스프링 MVC2");
        requestUpdateLectureDto.setCreator("김영한");
        requestUpdateLectureDto.setDescription("Hello world!!");
        requestUpdateLectureDto.setLectureUrl("https://udemy.com");
        lectureService.updateLecture(targetId, requestUpdateLectureDto);

        // then
        String expected = "스프링 MVC2";
        String actual = lectureService.getLecture(targetId).getTitle();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("강의 삭제 테스트")
    void deleteLecture() {
        // given
        addLectureOne();

        Long targetId = lectureService.getLatestAddedLecture(1).get(0).getId();

        // when
        lectureService.deleteLecture(targetId);

        // then
        assertThat(lectureRepository.existsById(1L)).isEqualTo(false);
    }
}
