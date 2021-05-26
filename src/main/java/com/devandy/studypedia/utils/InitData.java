package com.devandy.studypedia.utils;

import com.devandy.studypedia.lecture.LectureRepository;
import com.devandy.studypedia.user.Role;
import com.devandy.studypedia.user.UserRepository;
import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.user.RequestSaveUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitData {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LectureRepository lectureRepository;

    public void addUsers(String email, String userName, String password, Role role) {
        RequestSaveUserDto userDto = new RequestSaveUserDto();
        userDto.setEmail(email);
        userDto.setUserName(userName);
        userDto.setPassword(passwordEncoder.encode(password));
        userDto.setRole(role);
        userRepository.save(userDto.toEntity());
    }

    public void addLectures(String title, String creator, Long authorId, String description, String lectureUrl,
                            Long views) {
        RequestSaveLectureDto lectureDto = new RequestSaveLectureDto();
        lectureDto.setTitle(title);
        lectureDto.setCreator(creator);
        lectureDto.setAuthorId(authorId);
        lectureDto.setAuthorName(userRepository.findById(authorId).get().getUserName());
        lectureDto.setDescription(description);
        lectureDto.setLectureUrl(lectureUrl);
        lectureDto.setViews(views);
        lectureRepository.save(lectureDto.toEntity());
    }

    public void injection() {
        addUsers("admin@gmail.com", "admin", "admin", Role.ADMIN);
        addUsers("guest@gmail.com", "guest", "password2", Role.USER);
        for (int i = 1; i <= 5; i++) {
            addUsers("user"+i+"@gmail.com", "user"+i,"password"+i,Role.USER);
        }

        addLectures("스프링 웹 MVC", "김영한", 5L,"이 강좌는 자바 서블릿(Servlet) 기반의 MVC 프레임워크인 스프링 웹 MVC(이하 스프링 MVC)에 대해 " +
                "학습합니다.", "https://www.inflearn.com/course/%EC%9B%B9-mvc#", 22L);
        addLectures("스프링 프레임워크 입문",
                "백기선", 4L, "Spring-PetClinic이라는 스프링 공식 예제 프로젝트의 코드를 보며 다음의 스프링의 핵심 기능을 쉽고 빠르게 이해할 수 있습니다.", "https" +
                        "://www.inflearn.com/course/spring#", 21L);
        addLectures("윤재성의 스프링 프레임워크 개발자를 위한 실습을 통한 입문 과정", "윤재성", 2L, "본 과정은 Spring Framework를 학습할 수 있는 과정입니다. 대부분의 " +
                "강좌들이 Spring MVC Project만을 소개하고 있는데 이 때문에 용어, 개념, 동작 원리등을 제대로 파악하지 못하게 되어 어떻게 동작하는지 모르고 학습을 하게 됩니다",
                "https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED" +
                        "%81%AC-%EC%9E%85%EB%AC%B8#",23L);
        addLectures("실전! 스프링 데이터 JPA", "김영한", 3L, "스프링 데이터 JPA는 기존의 한계를 넘어 마치 마법처럼, 리포지토리에 구현 클래스 없이 인터페이스 " +
                "만으로 개발을 완료할 수 있습니다. 그리고 반복 개발해온 기본 CRUD 기능도 모두 제공합니다. 스프링 데이터 JPA 실무 노하우를 전해드립니다.", "https://www" +
                ".inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%8D%B0%EC%9D%B4%ED%84%B0-JPA-%EC%8B%A4%EC%A0%84" +
                "#",39L);
        addLectures("Spring Boot Starter!", "DevAndy", 1L, "스프링 배우자!", "https://youngjinmo.github.io", 12L);
    }
}
