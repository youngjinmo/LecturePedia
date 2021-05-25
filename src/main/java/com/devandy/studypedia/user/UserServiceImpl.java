package com.devandy.studypedia.user;

import com.devandy.studypedia.utils.HttpSessionUtils;
import com.devandy.studypedia.web.dto.user.RequestSaveUserDto;
import com.devandy.studypedia.web.dto.user.RequestUpdateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean validationEmail(String email) {
        return userRepository.findByEmail(email)==null;
    }

    @Override
    public boolean validationPasswordByLogin(String email, String password) {
        User targetUser = userRepository.findByEmail(email);
        boolean result = passwordEncoder.matches(password, targetUser.getPassword());
        return result;
    }

    @Override
    public void createUser(RequestSaveUserDto requestSaveUserDto) {
        String encodedPassword = passwordEncoder.encode(requestSaveUserDto.getPassword());
        requestSaveUserDto.setPassword(encodedPassword);
        requestSaveUserDto.setRole(Role.USER);
        userRepository.save(requestSaveUserDto.toEntity());
    }

    @Override
    public boolean isAvaliableUpdateUser(Long id, HttpSession session) {
        if(HttpSessionUtils.isLoginUser(session)
                && HttpSessionUtils.getUserFromSession(session).getId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public void updateUser(Long id, RequestUpdateUserDto requestUpdateUserDto) {
        User userDto = userRepository.findById(id).get();
        userDto.setEmail(requestUpdateUserDto.getEmail());
        userDto.setUserName(requestUpdateUserDto.getUserName());
        userRepository.save(userDto);
    }

    @Override
    public void deleteUser(Long id) {
        User targetUser = userRepository.findById(id).get();
        userRepository.delete(targetUser);

    }
}
