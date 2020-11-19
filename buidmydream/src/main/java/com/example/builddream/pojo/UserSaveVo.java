package com.example.builddream.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class UserSaveVo {
    /**
     * 用户名，不能为空
     */
    private String username;

    /**
     * 密码，不能为空
     */
    private String password;

    /**
     * 邮箱地址
     */
    private String emailAddress;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 生日
     */
    private String birthDay;

    /**
     * 电话号码，不能为空，只是数字
     */
    private Long telephoneNum;

    /**
     *微信账号
     */
    private String wechatNum;

    /**
     * 备注
     */
    private String remarks;
}
