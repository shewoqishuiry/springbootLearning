package com.example.builddream.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.builddream.dto.UserEntityDto;
import com.example.builddream.pojo.*;
import com.example.builddream.mapper.UserMapper;
import com.example.builddream.utils.BaseResponse;
import com.example.builddream.utils.UserManagerErrorCodeEnum;
import com.example.builddream.utils.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Service
public class UserService extends ServiceImpl<UserMapper, UserDo> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static Map<Integer, String> ENCODER_TYPE = new HashMap<>();

    private final static Map<String, PasswordEncoder> ENCODER_MAP = new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    private final static String PASSWORD_FORMAT = "{%s}%s";

    static {
        ENCODER_TYPE.put(0, "noop");
        ENCODER_TYPE.put(1, "bcrypt");
        ENCODER_TYPE.put(2, "pbkdf2");
        ENCODER_TYPE.put(3, "scrypt");
        ENCODER_TYPE.put(4, "sha256");
        ENCODER_MAP.put("noop", NoOpPasswordEncoder.getInstance());
        ENCODER_MAP.put("bcrypt", new BCryptPasswordEncoder());
        ENCODER_MAP.put("pbkdf2", new Pbkdf2PasswordEncoder());
        ENCODER_MAP.put("scrypt", new SCryptPasswordEncoder());
        ENCODER_MAP.put("sha256", new StandardPasswordEncoder());
    }

    public UserDo getUserByName(String name) {
        if (!isUserExist(name)) {
            logger.error("用户不存在");
            return null;
        }

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",name);
        return super.getOne(queryWrapper);
    }

    public UserReponseVo getOneUserByName(String name) {
        if (!isUserExist(name)) {
            logger.error("用户不存在");
            return null;
        }

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",name);
        return UserEntityDto.userDoToUserReponseVo(super.getOne(queryWrapper));
    }

    @RolesAllowed({"ROLE_ADMIN"})
    public ErrorCode removeOneUserByName(UserDeleteVo userDeleteVo) {
        UserDo userDo = super.getById(userDeleteVo.getId());
        if (userDo == null) {
            return UserManagerErrorCodeEnum.USER_ID_NOT_EXIST;
        }
        if (!userDo.getUsername().equals(userDeleteVo.getUserName())) {
            return UserManagerErrorCodeEnum.USER_NAME_AND_USER_ID_NOT_MATCH;
        }
        if (!super.removeById(userDeleteVo.getId())) {
            return UserManagerErrorCodeEnum.REMOVE_USER_FAIL;
        }
        
        return UserManagerErrorCodeEnum.SUCCESS;
    }

    public ErrorCode saveOneUser(UserSaveVo userSaveVo) {
        if (isUserExist(userSaveVo.getUsername())) {
            return UserManagerErrorCodeEnum.USER_NAME_HAS_ALREADY_EXIST;
        }
        
        String password = new BCryptPasswordEncoder().encode(userSaveVo.getPassword());
        userSaveVo.setPassword(password);

        try {
            if (!super.save( UserEntityDto.userSaveVoToUserDo(userSaveVo))) {
                return UserManagerErrorCodeEnum.REGISTER_ERROR_FAIL;
            }
        } catch (Exception e) {
            logger.error("异常了！",e);
            return UserManagerErrorCodeEnum.REGISTER_ERROR_FAIL;
        }

        return UserManagerErrorCodeEnum.SUCCESS;
    }

    public ErrorCode updateOneUser(UserUpdateVo userUpdateVo) {
        if(super.getById(userUpdateVo.getId()) == null) {
            return UserManagerErrorCodeEnum.USER_ID_NOT_EXIST;
        }

        if (!super.updateById(UserEntityDto.userUpdateVoToUserDo(userUpdateVo))) {
            return UserManagerErrorCodeEnum.MODIFY_USER_FAIL;
        }
        return UserManagerErrorCodeEnum.SUCCESS;
    }
    
    public boolean isUserExist(String userName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",userName);
        if (super.getOne(queryWrapper) != null) {
            return true;
        }
        
        return false;
    }


    public String getUserLoginSuccessUrl(String userName) {
        return userMapper.getUserLoginSuccessDefaultPermissionUrl(userName);
    }

    public List<String> getUserPermissionUrls (String userName) {
        return userMapper.getUerPermissionUrls(userName);
    }

    public List<String> getUserRoles(String userName) {
        return userMapper.getUserRoles(userName);
    }

}
