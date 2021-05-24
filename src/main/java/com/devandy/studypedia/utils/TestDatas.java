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
public class TestDatas {

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

    public void addLectures(String title, String creator, Long authorId, String content, String lectureUrl) {
        RequestSaveLectureDto lectureDto1 = new RequestSaveLectureDto();
        lectureDto1.setTitle(title);
        lectureDto1.setCreator(creator);
        lectureDto1.setAuthor(authorId);
        lectureDto1.setDescription(content);
        lectureDto1.setLectureUrl(lectureUrl);
        lectureRepository.save(lectureDto1.toEntity());
    }
}
