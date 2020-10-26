package com.example.builddream.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.builddream.pojo.UserDo;
import com.example.builddream.mapper.UserMapper;
import com.example.builddream.utils.BaseResponse;
import com.example.builddream.utils.CommonErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Service
public class UserService extends ServiceImpl<UserMapper, UserDo> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static Map<Integer, String> ENCODER_TYPE = new HashMap<>();

    private final static Map<String, PasswordEncoder> ENCODER_MAP = new HashMap<>();

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

    public UserDo getOneUserByName(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",name);
        queryWrapper.ne("isDeleted",1);
        return super.getOne(queryWrapper);
    }

    public boolean updateOneUserByName(UserDo userDo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",userDo.getUsername());
        queryWrapper.ne("isDeleted",1);
        return super.update(userDo,queryWrapper);
    }

    public boolean saveOneUser(UserDo userDo) {
        if (getOneUserByName(userDo.getUsername()) != null) {
            throw new RuntimeException("用户名已存在！");
        }

        String password = new BCryptPasswordEncoder().encode(userDo.getPassword());
        userDo.setPassword(password);
        userDo.setIsDeleted(0);
        return super.save(userDo);
    }

    public boolean deleteUser(UserDo userDo) {
        userDo.setIsDeleted(1);
        return updateOneUserByName(userDo);
    }

    public boolean realDeleteUser(UserDo userDo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",userDo.getUsername());
        return super.update(userDo,queryWrapper);
    }

}
