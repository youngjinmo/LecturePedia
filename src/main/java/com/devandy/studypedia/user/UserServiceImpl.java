package com.devandy.studypedia.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean emailValidation(String email) {
        return userRepository.findByEmail(email)==null;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean validationLoginPassword(String email, String password) {
        User loginUser = userRepository.findByEmail(email);
        if(loginUser==null) {
            System.out.println("해당 이메일의 유저가 존재하지 않습니다.");
            return false;
        }
        if(!loginUser.matchPassword(password)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }
        return true;
    }
}
