package com.example.ucms.biz.controller;

import com.example.ucms.biz.entity.Role;
import com.example.ucms.biz.service.RoleService;
import com.example.ucms.common.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by j23li on 2018/12/19.
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public Response<List<Role>> getRoles(){
        List<Role> roles;
        try{
            roles = roleService.getRoles();
        } catch (RuntimeException e){
            return new Response<>(Response.R_CODE_NOTOK, e.getMessage());
        }
        Response<List<Role>> response = new Response<List<Role>>();
        response.setData(roles);
        return response;

    }

    @RequestMapping(method = RequestMethod.POST)
    public Response addRole(@RequestBody Role role){
        try {
            roleService.addRole(role);
        } catch (RuntimeException e){
            return new Response(Response.R_CODE_NOTOK, e.getMessage());
        }
        return new Response();

    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public Response<Role> getRoleByName(@PathVariable String name){
        Role role;
        try{
            role = roleService.getRoleByName(name);
        } catch (RuntimeException e){
            return new Response<>(Response.R_CODE_NOTOK, e.getMessage());
        }

        Response<Role> response = new Response<>();
        response.setData(role);
        return response;
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.DELETE)
    public Response deleteByName(@PathVariable String name){
        try {
            roleService.deleteRoleByName(name);
        } catch (RuntimeException e){
            return new Response(Response.R_CODE_NOTOK, e.getMessage());
        }
        return new Response();
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.PUT)
    public Response updateByName(@PathVariable String name, @RequestBody Role role){
        try {
            roleService.updateByName(name, role);
        } catch (RuntimeException e){
            return new Response(Response.R_CODE_NOTOK, e.getMessage());
        }
        return new Response();
    }
}
