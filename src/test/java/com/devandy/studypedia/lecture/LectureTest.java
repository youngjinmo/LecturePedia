package com.devandy.studypedia.lecture;

import com.devandy.studypedia.utils.HttpSessionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LectureTest {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private HttpSession session;

    @Test
    @DisplayName("Lecture 등록 테스트")
    void addLecture() {
        // given
        Lecture lecture = new Lecture();
        lecture.setTitle("스프링 MVC");
        lecture.setCreator("김영한");
        lecture.setLectureUrl("https://inflearn.com");
        lecture.setPublisher(1L);

        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY,"admin");

        // when
        lectureService.postLecture(lecture);

        // then
        Lecture targetLecture = lectureRepository.findById(1L).get();
        assertEquals(lecture.getTitle(), targetLecture.getTitle());
    }
}
