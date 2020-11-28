package com.example.builddream.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.builddream.pojo.mybatisdo.RolePermissionDo;

public interface RolePermissionService {
    public RolePermissionDo getOneRolePermision(QueryWrapper queryWrapper);
    public boolean saveOrUpdate(RolePermissionDo rolePermissionDo);
}
