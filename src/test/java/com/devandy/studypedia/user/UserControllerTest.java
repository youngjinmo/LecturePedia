package com.devandy.studypedia.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("회원가입 API 테스트")
    void getSignUpPage() throws Exception {
        String body = this.testRestTemplate.getForObject("/user/signup", String.class);
        assertThat(body).contains("회원가입");
    }

    @Test
    @DisplayName("로그인 API 테스트")
    void getSignInPage() throws Exception {
        String body = this.testRestTemplate.getForObject("/user/login", String.class);
        assertThat(body).contains("로그인");
    }

}
