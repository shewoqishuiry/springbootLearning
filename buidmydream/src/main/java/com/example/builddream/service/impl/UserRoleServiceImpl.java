package com.example.builddream.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.builddream.mapper.UserRoleMapper;
import com.example.builddream.pojo.ModifyRoleRequestVo;
import com.example.builddream.pojo.mybatisdo.RoleDo;
import com.example.builddream.pojo.mybatisdo.RolePermissionDo;
import com.example.builddream.pojo.mybatisdo.UserDo;
import com.example.builddream.pojo.mybatisdo.UserRoleDo;
import com.example.builddream.service.RolePermissionService;
import com.example.builddream.service.RoleService;
import com.example.builddream.service.UserRoleService;
import com.example.builddream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleDo> implements UserRoleService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 学习事务：
     * 1、事务内代码抛异常后，该事务失效
     * 2、事务内部如果正常返回，则事务执行成功，所以中途如果有失败，不要用返回，也不要抛出异常
     * 3、 让checked例外也回滚：在整个方法前加上 @Transactional(rollbackFor=Exception.class)
     * 4、让unchecked例外不回滚： @Transactional(notRollbackFor=RunTimeException.class)
     * 5、不需要事务管理的(只查询的)方法：@Transactional(propagation=Propagation.NOT_SUPPORTED)
     * 6、如果不添加rollbackFor等属性，Spring碰到Unchecked Exceptions都会回滚，不仅是RuntimeException，也包括Error。
     * @param modifyRoleRequestVo
     * @return
     */
    @Override
    @Transactional
    public void modifyUserRole(ModifyRoleRequestVo modifyRoleRequestVo) {
        List<String> userRoles = userService.getUserRoles(modifyRoleRequestVo.getUserName());
        boolean bIsAlreadyHas = false;
        //判断是否已经拥有这个角色
        for (String userRole: userRoles) {
            if (userRole.equals(modifyRoleRequestVo.getRoleName())) {
                bIsAlreadyHas = true;
                break;
            }
        }
        //没有则插入
        //查询角色列表
        RoleDo roleDo = roleService.getRoleByRoleName(modifyRoleRequestVo.getRoleName());
        if (!bIsAlreadyHas) {
            //查询用户信息
            UserDo userDo = userService.getUserByName(modifyRoleRequestVo.getUserName());
            //添加用户角色
            addRoleToUser(userDo.getId(),roleDo.getId());
        } else  {
            //保存用户权限url
            RolePermissionDo rolePermissionDo = new RolePermissionDo();
            rolePermissionDo.setPermissionUrl(modifyRoleRequestVo.getSuccessDefaultUrl());
            rolePermissionDo.setRoleId(roleDo.getId());
            rolePermissionService.saveOrUpdate(rolePermissionDo);

            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("permission_url",modifyRoleRequestVo.getSuccessDefaultUrl());
            queryWrapper.eq("role_id",roleDo.getId());
            RolePermissionDo rolePermissionDo1 = rolePermissionService.getOneRolePermision(queryWrapper);
            userService.setDefaultSuccessUrl(rolePermissionDo1.getPermissionId(), modifyRoleRequestVo.getUserName());
        }
    }

    @Override
    public boolean addRoleToUser(Long userId,Long roleId) {
        UserRoleDo userRoleDo = new UserRoleDo();
        userRoleDo.setUserId(userId);
        userRoleDo.setRoleId(roleId);
        return super.save(userRoleDo);
    }

}
