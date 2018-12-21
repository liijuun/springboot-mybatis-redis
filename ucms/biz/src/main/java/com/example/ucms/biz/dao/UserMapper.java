package com.example.ucms.biz.dao;

import com.example.ucms.biz.entity.User;
import com.example.ucms.biz.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by j23li on 2018/12/16.
 */

@Mapper
public interface UserMapper {

    User getUserByUid(String uid);
    User getUserById(Integer id);
    void addUser(User user);
    void deleteUserByUid(String uid);
    List<User> getUsers();

    void addRole2User(UserRole userRole);
    List<UserRole> getUserRoles(Integer id);
    void deleteUserRole(UserRole userRole);
}
