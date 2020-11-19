package com.example.builddream.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserUpdateVo {
    /**
     * 用户id，逐渐，自增
     */
    private Long id;
    /**
     * 用户名，不能为空
     */
    private String username;

//    /**
//     * 密码，不能为空
//     */
//    private String password;

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
