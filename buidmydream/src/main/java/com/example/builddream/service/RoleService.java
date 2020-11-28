package com.example.builddream.service;

import com.example.builddream.pojo.mybatisdo.RoleDo;

import java.util.List;

public interface RoleService {
    public RoleDo getRoleByRoleName(String roleName);
    public List<RoleDo> getAllRoles();
}
