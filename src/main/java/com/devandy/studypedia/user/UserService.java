package com.devandy.studypedia.user;

import com.devandy.studypedia.web.dto.user.RequestSaveUserDto;
import com.devandy.studypedia.web.dto.user.RequestUpdateUserDto;

import javax.servlet.http.HttpSession;

public interface UserService {
    void createUser(RequestSaveUserDto requestSaveUserDto);
    boolean isAvaliableUpdateUser(Long id, HttpSession session);
    void updateUser(Long id, RequestUpdateUserDto requestUpdateUserDto);
    boolean emailValidation(String email);
    boolean validationLogin(String email, String password);

}
