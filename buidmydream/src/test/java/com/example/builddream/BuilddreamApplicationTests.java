package com.example.builddream;

import com.example.builddream.config.GetPersonInfoProperties;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class BuilddreamApplicationTests {
    @Value("${personinfo.age}")
    private int age;
    @Value("${personinfo.name}")
    private String name;

    @Autowired
    private GetPersonInfoProperties getPersonInfoProperties;

    @Test
    void contextLoads() {
    }

    @Test
    public void getAge(){
        System.out.println(age);
    }

    @Test
    public void getName(){
        System.out.println(name);
    }

    @Test
    public void getPersonInfoProperties(){
        System.out.println(getPersonInfoProperties.getName() + ":" +getPersonInfoProperties.getAge());
    }
}
