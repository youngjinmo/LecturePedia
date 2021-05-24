package com.devandy.studypedia.user;

import com.devandy.studypedia.web.dto.user.RequestSaveUserDto;
import com.devandy.studypedia.web.dto.user.RequestUpdateUserDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @AfterEach
    void deleteUserAfterTest() {
        userRepository.deleteAll();
    }

    private void addUserOne(String email, String userName, String password) {
        RequestSaveUserDto requestSaveUserDto = new RequestSaveUserDto();
        requestSaveUserDto.setEmail(email);
        requestSaveUserDto.setUserName(userName);
        requestSaveUserDto.setPassword(password);
        requestSaveUserDto.setRole(Role.USER);

        userService.createUser(requestSaveUserDto);
    }

    @Test
    @DisplayName("회원가입 테스트")
    void createUser() {
        // given
        RequestSaveUserDto requestSaveUserDto = new RequestSaveUserDto();
        requestSaveUserDto.setEmail("youngjinmo@gmail.com");
        requestSaveUserDto.setUserName("DevAndy");
        requestSaveUserDto.setPassword("1q2w3e4r");
        requestSaveUserDto.setRole(Role.USER);

        // when
        userService.createUser(requestSaveUserDto);

        // then
        User actual = userRepository.findByEmail(requestSaveUserDto.getEmail());
        assertEquals(requestSaveUserDto.getEmail(), actual.getEmail());
    }

    @Test
    @DisplayName("패스워드 암호화 테스트")
    void encodePassword() {
        // given
        String rawPassword1 = "12345678";
        String rawPassword2 = "@12345678!";
        addUserOne("test@gmail.com", "test", rawPassword1);
        addUserOne("test2@gmail.com", "test2", rawPassword2);

        // when
        String encodedPassword = userRepository.findByEmail("test@gmail.com").getPassword();
        String encodedPassword2 = userRepository.findByEmail("test2@gmail.com").getPassword();

        // then
        assertAll(
                () -> assertTrue(passwordEncoder.matches(rawPassword1,encodedPassword)),
                () -> assertTrue(passwordEncoder.matches(rawPassword2,encodedPassword2)),
                () -> assertNotEquals(encodedPassword, encodedPassword2)
        );
    }

    @Test
    @DisplayName("사용자 정보 수정 테스트")
    void updateUser() {
        // given
        addUserOne("test@gmail.com", "test", "password");
        Long targetId = userRepository.findByEmail("test@gmail.com").getId();

        // when
        RequestUpdateUserDto requestUpdateUserDto = new RequestUpdateUserDto();
        requestUpdateUserDto.setEmail("test@naver.com");
        requestUpdateUserDto.setUserName("updateUser");
        requestUpdateUserDto.setPassword("password!");
        userService.updateUser(targetId, requestUpdateUserDto);

        // then
        User updatedUser = userRepository.findByEmail("test@naver.com");
        assertEquals("updateUser",updatedUser.getUserName());
    }

    @Test
    @DisplayName("회원 삭제 테스트")
    void deleteUser() {
        // given
        addUserOne("test@gmail.com", "test", "password");

        // when
        Long id = userRepository.findByEmail("test@gmail.com").getId();
        userService.deleteUser(id);

        // then
        assertFalse(userRepository.existsById(id));
    }
}
