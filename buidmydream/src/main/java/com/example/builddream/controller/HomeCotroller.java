package com.example.builddream.controller;

import com.example.builddream.pojo.UserDo;
import com.example.builddream.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeCotroller {

   private final UserService userService;

    @GetMapping({"/", "/index", "/home"})
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(UserDo userDo){
        // 此处省略校验逻辑
        userService.saveOneUser(userDo);
        return "redirect:register?success";
    }


}
