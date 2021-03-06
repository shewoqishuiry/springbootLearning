package com.example.builddream.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Value;

import java.util.Date;

@Data
@TableName("user")
public class User {
    /**
     * 用户id，逐渐，自增
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 用户名，不能为空
     */
    @TableField(value = "name",insertStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    /**
     * 密码，不能为空
     */
    @TableField(value = "passWord",insertStrategy = FieldStrategy.NOT_EMPTY)
    private String passWord;

    /**
     * 邮箱地址
     */
    @TableField(value = "emailAddress")
    private String emailAddress;

    /**
     * 公司名称
     */
    @TableField(value = "companyName")
    private String companyName;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private String birthDay;

    /**
     * 电话号码，不能为空，只是数字
     */
    @TableField(value = "telephoneNum",insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long telephoneNum;

    /**
     *微信账号
     */
    @TableField(value = "wechatNum")
    private String wechatNum;

    /**
     * 注册时间,插入时设置此字段的值
     */
    @TableField(value = "registTime",fill = FieldFill.INSERT)
    private Date registTime;

    /**
     * 更新时间，修改时设置此字段的值
     */
    @TableField(value = "updateTime",fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

}
