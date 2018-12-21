package com.example.ucms.biz.service;

import com.example.ucms.biz.dao.RoleMapper;
import com.example.ucms.biz.dao.UserMapper;
import com.example.ucms.biz.entity.Role;
import com.example.ucms.biz.entity.User;
import com.example.ucms.biz.entity.UserRole;
import com.example.ucms.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j23li on 2018/12/19.
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;


    public Role getRoleById(Integer id){
        return roleMapper.getRoleById(id);
    }

    public Role getRoleByName(String name){
        Role role = roleMapper.getRoleByName(name);
        if (null == role){
            throw new ServiceException(
                    String.format("Role(name=%s) not exist", name)
            );
        }
        return role;
    }

    public void addRole(Role role){
        if (null != role.getId()){
            throw new ServiceException(
                    "Role id is DB auto-increment, must null"
            );
        }

        if (null != roleMapper.getRoleByName(role.getName())){
            throw new ServiceException(
                    String.format("Role(name=%s) already exist", role.getName())
            );
        }

        roleMapper.addRole(role);
    }

    public List<Role> getRoles(){
        return roleMapper.getRoles();
    }

    public void deleteRoleById(Integer id){
        Role r = getRoleById(id);
        if (r == null){
            throw new ServiceException(String.format(
                    "Role(id:%s) not exist.", id
            ));
        } else {
            roleMapper.deleteRoleById(id);
        }
    }

    public void deleteRoleByName(String name){
        Role r = getRoleByName(name);
        if (null == r){
            throw new ServiceException(
                    String.format("Role(name=%s) not exist", name)
            );
        }
        List<UserRole> userRoles = roleMapper.getUsersBindToRole(r.getId());
        if (!userRoles.isEmpty()){
            List<User> users = new ArrayList<>();
            for (UserRole userRole: userRoles) {
                users.add(userMapper.getUserById(userRole.getUser_id()));
            }

            throw new ServiceException(
                    String.format("Some Users(%s) bind to Role(name=%s), consider unbind firstly",
                            users.toString(), name)
            );
        }

        roleMapper.deleteRoleByName(name);
    }


    public void deleteRole(Role role){
        deleteRoleById(role.getId());
    }

    public void updateByName(String name, Role role){
        Role r = roleMapper.getRoleByName(name);
        if (null == r){
            throw new ServiceException(
                    String.format("Role(name=%s) not exist", name)
            );
        } else {
            r.setName(role.getName());
            r.setCode(role.getCode());
            r.setDescription(role.getDescription());
            r.setWight(role.getWight());
            roleMapper.updateRoleByName(r);
        }
    }
}
