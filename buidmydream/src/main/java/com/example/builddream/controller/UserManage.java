package com.example.builddream.controller;

import com.example.builddream.pojo.User;
import com.example.builddream.service.UserService;
import com.example.builddream.utils.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Api("用户信息管理")
@RestController
public class UserManage {

    @Autowired
    private UserService userService;

    @ApiOperation("根据用户名获取用户信息")
    @GetMapping("/getUserByName/{name}")
    public BaseResponse getUserByName(@PathVariable("name") String name){
       return userService.getUserByName(name);
    }

    @ApiOperation("添加新用户")
    @PostMapping("/addUser")
    public BaseResponse addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @ApiOperation("修改用户信息")
    @RequestMapping(value = "modifyUser",method = RequestMethod.PUT)
    public BaseResponse modifyUser(@RequestBody User user){
        return userService.modifyUser(user);
    }

    @ApiOperation("用户登录")
    @PostMapping("/userLogin")
    public BaseResponse userLogin(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "password",required = true) String password){
        return userService.loginUserCompare(name,password);
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "deleteUser",method = RequestMethod.DELETE)
    public BaseResponse deleteUser(User user) {
        return userService.deleteUser(user);
    }



    @RequestMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "user/user";
    }
    @RequestMapping("/admin")
    public String admin(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "admin/admin";
    }
}
