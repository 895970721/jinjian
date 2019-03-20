package com.fiveonezero.jinjianzi.Service.impl;

import com.fiveonezero.jinjianzi.Repository.UserRepository;
import com.fiveonezero.jinjianzi.Service.RegisterService;
import com.fiveonezero.jinjianzi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
