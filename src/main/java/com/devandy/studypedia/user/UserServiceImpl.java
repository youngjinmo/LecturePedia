package com.devandy.studypedia.user;

import com.devandy.studypedia.lecture.Lecture;
import com.devandy.studypedia.lecture.LectureRepository;
import com.devandy.studypedia.lecture.LectureService;
import com.devandy.studypedia.utils.HttpSessionUtils;
import com.devandy.studypedia.web.dto.user.RequestSaveUserDto;
import com.devandy.studypedia.web.dto.user.RequestUpdateUserDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        lectureService.updateAuthorName(id);
        userRepository.save(userDto);
    }

    @Override
    public void deleteUser(Long id) {
        User targetUser = userRepository.findById(id).get();
        userRepository.delete(targetUser);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<User> usersExceptAdmin = new ArrayList<>();
        for (User user : allUsers) {
            if(user.getRole().equals(Role.USER)) {
                usersExceptAdmin.add(user);
            }
        }
        return usersExceptAdmin;
    }

    @Override
    public boolean hasAuthority(Long lectureId, HttpSession session) {
        if(!HttpSessionUtils.isLoginUser(session)) {
            return false;
        }
        User currentUser = HttpSessionUtils.getUserFromSession(session);
        Lecture targetLecture = lectureRepository.findById(lectureId).get();
        String sessionedUserName = currentUser.getUserName();
        String lectureAuthorName = targetLecture.getAuthorName();
        return lectureAuthorName.equals(sessionedUserName) || currentUser.getRole().equals(Role.ADMIN);
    }
}
