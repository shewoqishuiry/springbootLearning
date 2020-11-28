package com.example.builddream.dto;


import com.example.builddream.pojo.mybatisdo.UserDo;
import com.example.builddream.pojo.UserReponseVo;
import com.example.builddream.pojo.UserSaveVo;
import com.example.builddream.pojo.UserUpdateVo;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UserEntityDto {

    public static UserDo userSaveVoToUserDo (UserSaveVo userSaveVo) {
        UserDo userDo = new UserDo();
        userDo.setUsername(userSaveVo.getUsername());
        userDo.setPassword(userSaveVo.getPassword());
        userDo.setCompanyName(userSaveVo.getCompanyName());
        userDo.setEmailAddress(userSaveVo.getEmailAddress());
        userDo.setTelephoneNum(userSaveVo.getTelephoneNum());
        userDo.setRemarks(userSaveVo.getRemarks());
        userDo.setWechatNum(userSaveVo.getWechatNum());
        String birthday = userSaveVo.getBirthDay();
        if (!StringUtils.isEmpty(birthday)) {
            birthday += ":00";
            birthday = birthday.replace("T"," ");
            Timestamp tBirthday = Timestamp.valueOf(birthday);
            if (tBirthday != null) {
                userDo.setBirthDay(tBirthday);
            }
        }
        return userDo;
    }

    public static UserDo userUpdateVoToUserDo (UserUpdateVo userUpdateVo) {
        UserDo userDo = new UserDo();
        userDo.setId(userUpdateVo.getId());
        userDo.setUsername(userUpdateVo.getUsername());
        userDo.setCompanyName(userUpdateVo.getCompanyName());
        userDo.setEmailAddress(userUpdateVo.getEmailAddress());
        userDo.setTelephoneNum(userUpdateVo.getTelephoneNum());
        userDo.setRemarks(userUpdateVo.getRemarks());
        userDo.setWechatNum(userUpdateVo.getWechatNum());
        Timestamp birthday = Timestamp.valueOf(userUpdateVo.getBirthDay());
        if (birthday != null) {
            userDo.setBirthDay(birthday);
        }
        return userDo;
    }

    public static UserReponseVo userDoToUserReponseVo(UserDo userDo) {
        UserReponseVo userReponseVo = new UserReponseVo();
        userReponseVo.setUsername(userDo.getUsername());
        userReponseVo.setCompanyName(userDo.getCompanyName());
        userReponseVo.setEmailAddress(userDo.getEmailAddress());
        userReponseVo.setTelephoneNum(userDo.getTelephoneNum());
        userReponseVo.setRemarks(userDo.getRemarks());
        userReponseVo.setWechatNum(userDo.getWechatNum());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (userDo.getBirthDay() != null) {
            userReponseVo.setBirthDay(df.format(userDo.getBirthDay()));
        }
        if (userDo.getRegistTime() != null) {
            userReponseVo.setRegistTime(df.format(userDo.getRegistTime()));
        }
        if (userDo.getUpdateTime() != null) {
            userReponseVo.setRegistTime(df.format(userDo.getUpdateTime()));
        }
        return userReponseVo;
    }

}
