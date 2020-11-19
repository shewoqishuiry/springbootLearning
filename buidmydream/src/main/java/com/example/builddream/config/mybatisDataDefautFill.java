package com.example.builddream.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class mybatisDataDefautFill implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "registTime", new Timestamp(new Date().getTime()));
        this.fillStrategy(metaObject, "updateTime",  new Timestamp(new Date().getTime()));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "updateTime", new Timestamp(new Date().getTime()));
    }
}
