package com.fiveonezero.jinjianzi.Service.impl;

import com.fiveonezero.jinjianzi.Repository.UserRepository;
import com.fiveonezero.jinjianzi.Service.LoginService;
import com.fiveonezero.jinjianzi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findByUsernameAndUserpassword(String username, String password) {
        return userRepository.findByUsernameAndUserpassword(username, password);
    }
}


