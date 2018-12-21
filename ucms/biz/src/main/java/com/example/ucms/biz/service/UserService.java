package com.example.ucms.biz.service;

import com.example.ucms.biz.dao.RoleMapper;
import com.example.ucms.biz.dao.UserMapper;
import com.example.ucms.biz.entity.Role;
import com.example.ucms.biz.entity.User;
import com.example.ucms.biz.entity.UserRole;
import com.example.ucms.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j23li on 2018/12/17.
 */
@Service
public class UserService {

    @Autowired
    private  UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;



    public User getUserByUid(String uid){
        if (uid == null){
            throw new ServiceException("Invalid uid: null");
        }
        return userMapper.getUserByUid(uid);
    }

    public User getUserById(Integer id){
        if (id == null){
            throw new ServiceException("Invalid id: null");
        }

        User user = userMapper.getUserById(id);
        if (user == null){
            throw new ServiceException("User not found.");
        } else {
            return user;
        }
    }

    public List<User> getUsers(){
        return userMapper.getUsers();
    }

    public void addUser(User user){
        if (null != user.getId()){
            throw new ServiceException("User id is DB auto-increment, must null");
        }
        if (null == user.getUid() || null == user.getName() || null == user.getPassword()){
            throw new ServiceException("User uid, name, password can not be null");
        }
        if( null != userMapper.getUserByUid(user.getUid())){
            throw new ServiceException(String.format("uid(%s) already been used", user.getUid()));
        }
        userMapper.addUser(user);
    }

    public void addRole2User(String uid, String roleName){

        Role role1 = roleMapper.getRoleByName(roleName);
        if (null == role1){
            throw new ServiceException(
                    String.format("Role(name=%s) not exist, consider create firstly", roleName)
            );
        }

        User user = userMapper.getUserByUid(uid);
        if (null == user){
            throw new ServiceException(
                    String.format("User(uid=%s) not exist", uid)
            );
        }

        UserRole userRole = new UserRole();
        userRole.setUser_id(user.getId());
        userRole.setRole_id(role1.getId());

        userMapper.addRole2User(userRole);
    }

    public List<Role> getUserRoles(String uid){
        User user = userMapper.getUserByUid(uid);
        if (null == user){
            throw new ServiceException(
                    String.format("User(uid=%s) not exist", uid)
            );
        }
        List<UserRole> userRoles = userMapper.getUserRoles(user.getId());
        List<Role> roles = new ArrayList<>();
        for (UserRole userrole: userRoles) {
            Role role = roleMapper.getRoleById(userrole.getRole_id());
            roles.add(role);
        }
        return roles;
    }

    public void deleteUserRole(String uid, String roleName){
        User user = userMapper.getUserByUid(uid);
        if (null == user){
            throw new ServiceException(
                    String.format("User(uid=%s) not exist", uid)
            );
        }
        Role role = roleMapper.getRoleByName(roleName);
        if (null == role){
            throw new ServiceException(
                    String.format("Role(name=%s) not exist", roleName)
            );
        }
        UserRole userRole = new UserRole();
        userRole.setUser_id(user.getId());
        userRole.setRole_id(role.getId());
        userMapper.deleteUserRole(userRole);
    }
}