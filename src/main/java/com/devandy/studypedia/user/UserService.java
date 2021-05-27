package com.devandy.studypedia.user;

import com.devandy.studypedia.web.dto.user.RequestSaveUserDto;
import com.devandy.studypedia.web.dto.user.RequestUpdateUserDto;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    void createUser(RequestSaveUserDto requestSaveUserDto);
    boolean isAvaliableUpdateUser(Long id, HttpSession session);
    void updateUser(Long id, RequestUpdateUserDto requestUpdateUserDto);
    boolean isNotExistEmail(String email);
    boolean validationLoginByPassword(String email, String password);
    void deleteUser(Long id);
    List<User> getAllUsers();
    boolean hasAuthority(Long lectureId, HttpSession session);
}
