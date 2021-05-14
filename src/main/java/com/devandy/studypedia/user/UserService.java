package com.devandy.studypedia.user;

public interface UserService {
    boolean emailValidation(String email);
    void createUser(User user);
    boolean validationLogin(String email, String password);
}
