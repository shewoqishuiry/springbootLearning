package com.example.builddream.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.builddream.pojo.mybatisdo.UserRoleDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleDo> {
}
