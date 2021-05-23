package com.devandy.studypedia.user;

import com.devandy.studypedia.web.dto.user.RequestSaveUserDto;
import com.devandy.studypedia.web.dto.user.RequestUpdateUserDto;
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

    @Test
    @DisplayName("회원가입 테스트")
    void createUser() {
        // given
        RequestSaveUserDto requestSaveUserDto = new RequestSaveUserDto();
        requestSaveUserDto.setEmail("youngjinmo@gmail.com");
        requestSaveUserDto.setUserName("DevAndy");
        requestSaveUserDto.setPassword("1q2w3e4r");

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
        String email = "test@gmail.com";
        String rawPassword = "12345678";

        RequestSaveUserDto requestSaveUserDto = new RequestSaveUserDto();
        requestSaveUserDto.setEmail(email);
        requestSaveUserDto.setUserName("test");
        requestSaveUserDto.setPassword(rawPassword);
        requestSaveUserDto.setRole(Role.USER);

        RequestSaveUserDto requestSaveUserDto2 = new RequestSaveUserDto();
        requestSaveUserDto2.setEmail("test@daum.net");
        requestSaveUserDto2.setUserName("test2");
        requestSaveUserDto2.setPassword(rawPassword);
        requestSaveUserDto2.setRole(Role.USER);

        // when
        userService.createUser(requestSaveUserDto);
        userService.createUser(requestSaveUserDto2);
        String encodedPassword = userRepository.findByEmail(email).getPassword();
        String encodedPassword2 = userRepository.findByEmail("test@daum.net").getPassword();

        // then
        assertAll(
                () -> assertTrue(passwordEncoder.matches(rawPassword,encodedPassword)),
                () -> assertTrue(passwordEncoder.matches(rawPassword,encodedPassword2)),
                () -> assertNotEquals(encodedPassword, encodedPassword2)
        );
    }

    @Test
    @DisplayName("사용자 정보 수정 테스트")
    void updateUser() {
        // given
        RequestSaveUserDto requestSaveUserDto = new RequestSaveUserDto();
        requestSaveUserDto.setEmail("test@gmail.com");
        requestSaveUserDto.setUserName("test");
        requestSaveUserDto.setPassword("12345678");
        requestSaveUserDto.setRole(Role.USER);

        RequestUpdateUserDto requestUpdateUserDto = new RequestUpdateUserDto();
        requestUpdateUserDto.setEmail(requestSaveUserDto.getEmail());
        requestUpdateUserDto.setUserName("test");
        requestUpdateUserDto.setPassword("12345679");

        // when
        userService.createUser(requestSaveUserDto);
        Long id = userRepository.findByEmail(requestSaveUserDto.getEmail()).getId();
        userService.updateUser(id, requestUpdateUserDto);

        // then
        User updatedUser = userRepository.findByEmail("test@gmail.com");
        assertEquals(requestUpdateUserDto.getPassword(),updatedUser.getPassword());
    }

    @Test
    @DisplayName("회원 삭제 테스트")
    void deleteUser() {
        // given
        RequestSaveUserDto requestSaveUserDto = new RequestSaveUserDto();
        String email = "test@gmail.com";
        requestSaveUserDto.setEmail(email);
        requestSaveUserDto.setUserName("test");
        requestSaveUserDto.setPassword("password");
        requestSaveUserDto.setRole(Role.USER);

        userService.createUser(requestSaveUserDto);

        // when
        Long id = userRepository.findByEmail(email).getId();
        userService.deleteUser(id);

        // then
        assertFalse(userRepository.existsById(id));
    }
}
