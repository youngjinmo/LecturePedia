package com.devandy.studypedia.utils;

import com.devandy.studypedia.user.Role;
import com.devandy.studypedia.user.User;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
    public static final String USER_SESSION_KEY = "sessionedUser";
    public static final String ADMIN_SESSION_KEY = "admin";

    public static User getUserFromSession(HttpSession session) {
        User sessionedUser = (User) session.getAttribute(USER_SESSION_KEY);
        if(sessionedUser==null) {
            return null;
        }
        return sessionedUser;
    }

    public static boolean isLoginUser(HttpSession session) {
        if(getUserFromSession(session)==null) {
            return false;
        }
        return true;
    }

    public static boolean hasRoleLoginUser(HttpSession session, Role role) {
        if(isLoginUser(session)) {
            Role roleOfCurrentUser = getUserFromSession(session).getRole();
            return roleOfCurrentUser.equals(role);
        }
        return false;
    }
}
