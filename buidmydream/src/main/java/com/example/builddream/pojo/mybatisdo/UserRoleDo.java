package com.example.builddream.pojo.mybatisdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_role")
public class UserRoleDo {
    /**
     * id
     */
    @TableId(value = "role_id",type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;
    /**
     * 角色id
     */
    @TableField(value = "role_id")
    private Long roleId;

}
