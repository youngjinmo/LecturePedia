package com.devandy.studypedia.user;

import com.devandy.studypedia.utils.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean emailValidation(String email) {
        return userRepository.findByEmail(email)==null;
    }

    @Override
    public void createUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public boolean validationLogin(String email, String password, HttpSession session) {
        User loginUser = userRepository.findByEmail(email);

        if(loginUser==null) {
            System.out.println("해당 이메일의 유저가 존재하지 않습니다.");
            return false;
        }

        if(!passwordEncoder.matches(password, loginUser.getPassword())) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }

        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, loginUser);
        System.out.println("로그인 !! : "+email);
        return true;
    }
}
