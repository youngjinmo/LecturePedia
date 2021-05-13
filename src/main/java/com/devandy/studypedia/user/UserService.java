package com.devandy.studypedia.user;

public interface UserService {
    boolean emailValidation(String email);
    void createUser(User user);
    boolean validationLoginPassword(String email, String password);
}
