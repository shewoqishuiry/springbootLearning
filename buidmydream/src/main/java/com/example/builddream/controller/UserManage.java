package com.example.builddream.controller;

import com.example.builddream.pojo.UserDeleteVo;
import com.example.builddream.pojo.UserDo;
import com.example.builddream.pojo.UserSaveVo;
import com.example.builddream.pojo.UserUpdateVo;
import com.example.builddream.service.UserService;
import com.example.builddream.utils.BaseResponse;
import com.example.builddream.utils.CommonErrorCodeEnum;
import com.example.builddream.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@Api("用户信息管理")
@RestController
public class UserManage {

    @Autowired
    private UserService userService;

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
    @RequestMapping(value = "deleteUser",method = RequestMethod.DELETE)
    public BaseResponse deleteUser(UserDeleteVo userDeleteVo) {
        ErrorCode errorCode = userService.removeOneUserByName(userDeleteVo);
        return  new BaseResponse(errorCode.getCode(),errorCode.getMessage());
    }

}
