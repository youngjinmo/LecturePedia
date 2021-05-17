package com.devandy.studypedia.web.dto.user;

import com.devandy.studypedia.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RequestUpdateUserDto {
    private String email;
    private String userName;
    private String password;

    @Builder
    public RequestUpdateUserDto(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .userName(userName)
                .password(password)
                .build();
    }
}
