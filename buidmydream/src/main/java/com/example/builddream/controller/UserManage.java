package com.example.builddream.controller;

import com.example.builddream.pojo.UserDo;
import com.example.builddream.service.UserService;
import com.example.builddream.utils.BaseResponse;
import com.example.builddream.utils.CommonErrorCodeEnum;
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
    public BaseResponse getUserByName(@PathVariable("name") String name){
        return new BaseResponse(userService.getOneUserByName(name));
    }

    @ApiOperation("添加新用户")
    @PostMapping("/addUser")
    public BaseResponse addUser(@RequestBody UserDo user){
       if (!ObjectUtils.isEmpty(userService.getOneUserByName(user.getUsername()))){
            return new BaseResponse(CommonErrorCodeEnum.REGISTER_NAME_DUPLICATED);
        }
        return userService.saveOneUser(user) ? new BaseResponse() : new BaseResponse(CommonErrorCodeEnum.REGISTER_ERROR_FAIL);
    }

    @ApiOperation("修改用户信息")
    @RequestMapping(value = "modifyUser",method = RequestMethod.PUT)
    public BaseResponse modifyUser(@RequestBody UserDo user){
        return userService.updateOneUserByName(user) ? new BaseResponse() : new BaseResponse(CommonErrorCodeEnum.MODIFY_USER_FAIL);
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "deleteUser",method = RequestMethod.DELETE)
    public BaseResponse deleteUser(UserDo user) {
        return userService.deleteUser(user) ? new BaseResponse() : new BaseResponse(CommonErrorCodeEnum.UNREGISTER_USER_FAIL);
    }

}
