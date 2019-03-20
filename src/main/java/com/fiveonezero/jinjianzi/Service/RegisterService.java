package com.fiveonezero.jinjianzi.Service;

import com.fiveonezero.jinjianzi.entity.User;

import java.util.List;

public interface RegisterService {
    List<User> findByUsername(String username);
}
