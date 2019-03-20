package com.fiveonezero.jinjianzi.Controller;

import com.fiveonezero.jinjianzi.Service.impl.RegisterServiceImpl;
import com.fiveonezero.jinjianzi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonInfoController {
    @Autowired
    RegisterServiceImpl registerService;

    @PostMapping(value = "/getInfo")
    public List<User> findByUsername(@RequestParam("username") String username){
        return registerService.findByUsername(username);
    }
}
