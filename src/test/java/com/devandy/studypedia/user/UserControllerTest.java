package com.devandy.studypedia.user;

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
    void getSignUpPage() throws Exception {
        String title = this.testRestTemplate.getForObject("/signup", String.class);

        assertThat(title).contains("회원가입");
    }

    @Test
    void getSignInPage() throws Exception {
        String title = this.testRestTemplate.getForObject("/signin", String.class);

        assertThat(title).contains("로그인");
    }

}
