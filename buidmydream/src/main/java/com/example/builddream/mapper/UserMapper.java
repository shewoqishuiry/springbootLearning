package com.example.builddream.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.builddream.pojo.mybatisdo.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<UserDo> {
    public String getUserLoginSuccessDefaultPermissionUrl(@Param("userName") String userName);

    public List<String> getUerPermissionUrls (String userName);

    public List<String> getUserRoles(String userName);

    public void setDefaultSuccessUrl(Map<String,Object> map);
}
