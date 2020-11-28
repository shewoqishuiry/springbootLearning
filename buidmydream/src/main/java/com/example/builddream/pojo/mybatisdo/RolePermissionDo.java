package com.example.builddream.pojo.mybatisdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("role_permissions")
public class RolePermissionDo {
    /**
     * id
     */
    @TableId(value = "permission_id",type = IdType.AUTO)
    private Long permissionId;
    /**
     * url地址
     */
    @TableField("permission_url")
    private String permissionUrl;
    /**
     * 角色id
     */
    @TableField("role_id")
    private Long roleId;
}
