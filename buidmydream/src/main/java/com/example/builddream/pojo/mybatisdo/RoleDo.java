package com.example.builddream.pojo.mybatisdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("roles")
public class RoleDo {
    /**
     * id
     */
    @TableId(value = "role_id",type = IdType.AUTO)
    private Long id;
    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    private String roleName;

}
