package com.example.ucms.biz.dao;

import com.example.ucms.biz.entity.Role;
import com.example.ucms.biz.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by j23li on 2018/12/19.
 */
@Mapper
public interface RoleMapper {
    void addRole(Role role);
    List<Role> getRoles();
    Role getRoleById(Integer id);
    void deleteRoleById(Integer id);
    Role getRoleByName(String name);
    void deleteRoleByName(String name);
    void updateRoleByName(Role role);
    List<UserRole> getUsersBindToRole(Integer id);
}
