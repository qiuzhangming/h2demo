package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void contextLoads2() throws SQLException {
        Connection connection = dataSource.getConnection();//获取连接
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());
        connection.close();//关闭连接
    }


    @Test
    public void userTest() {
        for (int i=0; i<100; i++) {
            User u = new User();
            u.setName("张三"+i);
            u.setAge(20);
            u.setSex(1);
            System.out.println(userRepository.save(u));
        }
    }

    @Test
    public void findUser() {
        System.out.println(userRepository.findAll());

    }

}
