package com.example.builddream.pojo;

import lombok.Data;

@Data
public class ModifyRoleRequestVo {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 角色
     */
    private String roleName;
    /**
     * 登录成功默认url
     */
    private String successDefaultUrl;
}
