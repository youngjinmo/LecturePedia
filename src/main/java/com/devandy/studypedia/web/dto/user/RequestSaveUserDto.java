package com.devandy.studypedia.web.dto.user;

import com.devandy.studypedia.user.Role;
import com.devandy.studypedia.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RequestSaveUserDto {
    private String email;
    private String userName;
    private String password;
    private Role role;

    @Builder
    public RequestSaveUserDto(String email, String userName, String password, Role role) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .userName(userName)
                .password(password)
                .role(role)
                .build();
    }
}
