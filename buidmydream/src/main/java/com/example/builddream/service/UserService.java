package com.example.builddream.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.builddream.pojo.User;
import com.example.builddream.mapper.UserMapper;
import com.example.builddream.utils.BaseResponse;
import com.example.builddream.utils.CommonErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     ********************************************返回给controller的接口**************************************************
     */

    public BaseResponse getUserByName(String name) {
        return new BaseResponse(getOneUserByName(name));
    }

    public BaseResponse loginUserCompare(String name, String password) {
        User user = getOneUserByName(name);
        return user.getPassWord().equals(password) ? new BaseResponse() : new BaseResponse(CommonErrorCodeEnum.LOGING_INFO_ERROR);
    }

    public BaseResponse addUser(User user) {
        if (!ObjectUtils.isEmpty(getOneUserByName(user.getName()))){
            return new BaseResponse(CommonErrorCodeEnum.REGISTER_NAME_DUPLICATED);
        }
        return super.save(user) ? new BaseResponse() : new BaseResponse(CommonErrorCodeEnum.REGISTER_ERROR_FAIL);
    }

    public BaseResponse modifyUser(User user) {
        return updateOneUserByName(user) ? new BaseResponse() : new BaseResponse(CommonErrorCodeEnum.MODIFY_USER_FAIL);
    }

    public BaseResponse deleteUser(User user) {
        user.setIsDeleted(1);
        return updateOneUserByName(user) ? new BaseResponse() : new BaseResponse(CommonErrorCodeEnum.UNREGISTER_USER_FAIL);
    }



    /**
     ******************************************返回给其他业务层的接口****************************************************
     */

    public User getOneUserByName(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",name);
        queryWrapper.ne("isDeleted",1);
        return super.getOne(queryWrapper);
    }

    public boolean updateOneUserByName(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",user.getName());
        queryWrapper.ne("isDeleted",1);
        return super.update(user,queryWrapper);
    }
}
