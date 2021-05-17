package com.devandy.studypedia.web.dto.user;

import com.devandy.studypedia.user.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ResponseUserDto {
    private Long id;
    private String email;
    private String userName;
    private String password;
    private Role role;

    public ResponseUserDto(Long id, String email, String userName, String password, Role role) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
