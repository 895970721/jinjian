package com.fiveonezero.jinjianzi.Controller;

import com.fiveonezero.jinjianzi.Service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginServiceImpl loginService;

    @PostMapping("/login")
    public String Dologin(
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        if(loginService.findByUsernameAndUserpassword(username,password).isEmpty()){
            return "账号或密码错误";
        }else{
            return "成功登陆";
        }
    }
}
