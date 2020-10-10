package com.example.builddream.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.builddream.entity.User;
import com.example.builddream.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserManage {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/getUserName",method = RequestMethod.GET)
    public String getUserName(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","大家好");
        jsonObject.put("data","试一下");

        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/getStudentInfo/{cardNo}/{className}",method = RequestMethod.GET)
    public String getStudentInfo(@PathVariable("cardNo") String cardNo,@PathVariable("className") String className){

        return "学生卡号：" + cardNo + "  学" +
                "" +
                "" +
                "]生班级：" + className;
    }

    @GetMapping("/getUserById/{Id}")
    public User getUserById(@PathVariable("Id") Long Id){
        User user = new User();

        try {
            user = userMapper.selectById(Id);
        }catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    @PostMapping
    public String addUser(@RequestBody User user){
       if (0 == userMapper.insert(user)) {
           return "success!";
       }

       return "failed!";
    }

}
