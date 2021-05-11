package com.devandy.studypedia.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원가입 테스트")
    void signUp() {
        // given
        User user = new User();
        user.setId(1L);
        user.setEmail("youngjinmo@gmail.com");
        user.setNickname("DevAndy");
        user.setPassword("1q2w3e4r");

        // when
        userRepository.save(user);

        // then
        User actual = userRepository.findByEmail(user.getEmail());
        assertEquals(user.getEmail(), actual.getEmail());
    }
}
