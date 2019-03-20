package com.fiveonezero.jinjianzi.Controller;

import com.fiveonezero.jinjianzi.Repository.UserRepository;
import com.fiveonezero.jinjianzi.Service.impl.RegisterServiceImpl;
import com.fiveonezero.jinjianzi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    RegisterServiceImpl registerService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public String Doregister(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("nick_name") String nick_name,
                              @RequestParam("sex") String sex){
        if(registerService.findByUsername(username).isEmpty()){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNick_name(nick_name);
            user.setSex(sex);
            userRepository.save(user);
            return "注册成功";
        }else{
            return "存在用户名";
        }
    }
}
