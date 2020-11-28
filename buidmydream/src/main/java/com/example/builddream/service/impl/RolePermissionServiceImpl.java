package com.example.builddream.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.builddream.mapper.RolePermissionMapper;
import com.example.builddream.pojo.mybatisdo.RolePermissionDo;
import com.example.builddream.service.RolePermissionService;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermissionDo> implements RolePermissionService {

    @Override
    public RolePermissionDo getOneRolePermision(QueryWrapper queryWrapper){
        return super.getOne(queryWrapper);
    }
    @Override
    public boolean saveOrUpdate(RolePermissionDo rolePermissionDo){
         return super.saveOrUpdate(rolePermissionDo);
    }

}
