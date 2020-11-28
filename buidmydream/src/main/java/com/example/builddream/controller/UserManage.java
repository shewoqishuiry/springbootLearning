package com.example.builddream.controller;

import com.example.builddream.pojo.*;
import com.example.builddream.service.UserRoleService;
import com.example.builddream.service.UserService;
import com.example.builddream.service.impl.UserRoleServiceImpl;
import com.example.builddream.service.impl.UserServiceImpl;
import com.example.builddream.utils.BaseResponse;
import com.example.builddream.utils.ErrorCode;
import com.example.builddream.utils.UserManagerErrorCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("用户信息管理")
@RestController
public class UserManage {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation("根据用户名获取用户信息")
    @GetMapping("/getUserByName/{name}")
    public BaseResponse getUserByName(@PathVariable("name") String name) {
        return new BaseResponse(userService.getOneUserByName(name));
    }

    @ApiOperation("添加新用户")
    @PostMapping("/addUser")
    public BaseResponse addUser(@RequestBody UserSaveVo userSaveVo) {
        ErrorCode errorCode = userService.saveOneUser(userSaveVo);
        return new BaseResponse(errorCode.getCode(),errorCode.getMessage());
    }

    @ApiOperation("修改用户信息")
    @RequestMapping(value = "modifyUser",method = RequestMethod.PUT)
    public BaseResponse modifyUser(@RequestBody UserUpdateVo userUpdateVo) {
        ErrorCode errorCode = userService.updateOneUser(userUpdateVo);
        return new BaseResponse(errorCode.getCode(),errorCode.getMessage());
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "deleteUser",method = RequestMethod.POST)
    public BaseResponse deleteUser(UserDeleteVo userDeleteVo) {
        ErrorCode errorCode = userService.removeOneUserByName(userDeleteVo);
        return  new BaseResponse(errorCode.getCode(),errorCode.getMessage());
    }

    @ApiOperation("修改用户角色和登录成功默认访问地址")
    @RequestMapping(value = "modifyUserRole",method = RequestMethod.POST)
    public BaseResponse modifyUserRole(ModifyRoleRequestVo modifyRoleRequestVo) throws Exception{
        userRoleService.modifyUserRole(modifyRoleRequestVo);
        return new BaseResponse();
    }



}
