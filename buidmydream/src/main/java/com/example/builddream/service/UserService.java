package com.example.builddream.service;

import com.example.builddream.pojo.UserDeleteVo;
import com.example.builddream.pojo.UserReponseVo;
import com.example.builddream.pojo.UserSaveVo;
import com.example.builddream.pojo.UserUpdateVo;
import com.example.builddream.pojo.mybatisdo.UserDo;
import com.example.builddream.utils.ErrorCode;

import java.util.List;
import java.util.Map;

public interface UserService {
    public UserDo getUserByName(String name);
    public List<String> getUserRoles(String userName);
    public String getUserLoginSuccessUrl(String userName);
    public ErrorCode saveOneUser(UserSaveVo userSaveVo);
    public ErrorCode removeOneUserByName(UserDeleteVo userDeleteVo);
    public UserReponseVo getOneUserByName(String name);
    public ErrorCode updateOneUser(UserUpdateVo userUpdateVo);
    public List<String> getUserPermissionUrls (String userName);
    public void setDefaultSuccessUrl(Long permisionId,String userName);
}
