package com.devandy.studypedia.user;

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
    void signUp() {
        // given
        User user = new User();
        user.setId(1L);
        user.setEmail("youngjinmo@gmail.com");
        user.setUserName("DevAndy");
        user.setPassword("1q2w3e4r");

        // when
        userRepository.save(user);

        // then
        User actual = userRepository.findByEmail(user.getEmail());
        assertEquals(user.getEmail(), actual.getEmail());
    }

    @Test
    @DisplayName("패스워드 암호화 테스트")
    void passwordEncode() {
        // given
        String email = "test@gmail.com";
        String rawPassword = "12345678";

        User user = new User();
        user.setEmail(email);
        user.setUserName("test");
        user.setPassword(rawPassword);
        user.setRole(Role.USER);

        User user2 = new User();
        user2.setEmail("test@daum.net");
        user2.setUserName("test2");
        user2.setPassword(rawPassword);
        user2.setRole(Role.USER);

        // when
        userService.createUser(user);
        userService.createUser(user2);
        String encodedPassword = userRepository.findByEmail(email).getPassword();
        String encodedPassword2 = userRepository.findByEmail("test@daum.net").getPassword();

        // then
        assertAll(
                () -> assertTrue(passwordEncoder.matches(rawPassword,encodedPassword)),
                () -> assertTrue(passwordEncoder.matches(rawPassword,encodedPassword2)),
                () -> assertNotEquals(encodedPassword, encodedPassword2)
        );
    }
}
