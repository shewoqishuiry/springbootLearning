package com.example.builddream.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.builddream.pojo.ModifyRoleRequestVo;
import com.example.builddream.pojo.mybatisdo.UserRoleDo;

public interface UserRoleService {
    public boolean addRoleToUser(Long userId,Long roleId);
    public void modifyUserRole(ModifyRoleRequestVo modifyRoleRequestVo);

}
