package com.example.builddream.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.builddream.mapper.RoleMapper;
import com.example.builddream.pojo.mybatisdo.RoleDo;
import com.example.builddream.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleDo> implements RoleService {

    @Override
    public List<RoleDo> getAllRoles() {
        return super.list();
    }

    @Override
    public RoleDo getRoleByRoleName(String roleName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_name",roleName);
        return super.getOne(queryWrapper);
    }

}
