package com.example.builddream.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class UserReponseVo {
    /**
     * 用户id，逐渐，自增
     */
    private Long id;

    /**
     * 用户名，不能为空
     */
    private String username;

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
     * 注册时间,插入时设置此字段的值
     */
    private String registTime;

    /**
     * 更新时间，修改时设置此字段的值
     */
    private String updateTime;

    /**
     * 备注
     */
    private String remarks;
}
