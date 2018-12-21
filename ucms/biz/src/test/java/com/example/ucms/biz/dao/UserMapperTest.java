package com.example.ucms.biz.dao;

import com.example.ucms.biz.entity.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

/**
 * Created by j23li on 2018/12/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public void setUp(){

    }

    public void tearDown(){

    }

    @Test
    public void testAddUser(){
        User user1 = new User();
        user1.setUid("61442533");
        user1.setName("j23li");
        user1.setGender("male");
        userMapper.addUser(user1);
    }

    @Test
    public void testAddUserWithSameUid(){
        String uid = "30001";
        User user = new User();
        user.setUid(uid);
        user.setName("Sam");
        userMapper.addUser(user);
        User user1 = new User();
        user1.setUid(uid);
        user1.setName("David");
        exception.expect(org.springframework.dao.DuplicateKeyException.class);
        exception.expectMessage("Duplicate entry '30001' for key 'uid'");
        userMapper.addUser(user1);
    }

    @Test
    public void testGetUserByUid(){
        User user = userMapper.getUserByUid("61442533");
        Assert.assertTrue(user.getName().equals("j23li"));
        System.out.println(user);
    }

}
