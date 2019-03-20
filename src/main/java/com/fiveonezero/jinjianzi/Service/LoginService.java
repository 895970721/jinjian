package com.fiveonezero.jinjianzi.Service;

import com.fiveonezero.jinjianzi.entity.User;

import java.util.List;

public interface LoginService {
    List<User> findByUsernameAndUserpassword(String username, String password);
}
