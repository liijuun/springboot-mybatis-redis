package com.example.ucms.biz.controller;

import com.example.ucms.biz.entity.Role;
import com.example.ucms.biz.entity.User;
import com.example.ucms.biz.service.UserService;
import com.example.ucms.common.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by j23li on 2018/12/17.
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Response<List<User>> getUsers(){
        List<User> users;
        try {
            users = userService.getUsers();
        } catch (RuntimeException e){
            return new Response<>("NotOK", e.getMessage());
        }
        Response<List<User>> response = new Response<>("OK", "SUCCESS");
        response.setData(users);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Response addUser(@Valid @RequestBody User user) {
        try {
            userService.addUser(user);
        } catch (RuntimeException e){
            return new Response("NotOK", e.getMessage());
        }
        return new Response();
    }

    @RequestMapping(path = "/{uid}", method = RequestMethod.GET)
    public Response<User> getUserByUid(@PathVariable String uid){
        User user;
        try{
            user = userService.getUserByUid(uid);
        } catch (RuntimeException e){
            System.out.println(e.getClass());
            return new Response<User>("NotOK", e.getMessage());
        }
        Response<User> response = new Response<User>();
        response.setData(user);
        return response;
    }

    @RequestMapping(path = "/{uid}", method = RequestMethod.DELETE)
    public Response deleteUserByUid(@PathVariable String uid){
        try {
            userService.deleteUserByUid(uid);
        } catch (RuntimeException e){
            return new Response(Response.R_CODE_NOTOK, e.getMessage());
        }
        return new Response();
    }

    @RequestMapping(path = "/{uid}/roles", method = RequestMethod.POST)
    public Response addRole2User(@PathVariable String uid, @RequestParam() String roleName){
        try{
            userService.addRole2User(uid, roleName);
        } catch (RuntimeException e){
            return new Response("NotOK", e.getMessage());
        }
        return new Response();
    }

    @RequestMapping(path = "/{uid}/roles", method = RequestMethod.GET)
    public Response<List<Role>> getUserRoles(@PathVariable String uid){
        List<Role> roles;
        try{
            roles = userService.getUserRoles(uid);
        } catch (RuntimeException e){
            return new Response<>(Response.R_CODE_NOTOK, e.getMessage());
        }
        Response<List<Role>> response = new Response<>();
        response.setData(roles);
        return response;
    }

    @RequestMapping(path = "/{uid}/roles", method = RequestMethod.DELETE)
    public Response deleteUserRole(@PathVariable String uid, @RequestParam String roleName){
        try{
            userService.deleteUserRole(uid, roleName);
        } catch (RuntimeException e){
            return new Response(Response.R_CODE_NOTOK, e.getMessage());
        }
        return new Response();
    }
}

