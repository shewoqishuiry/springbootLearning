package com.example.builddream.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.builddream.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
