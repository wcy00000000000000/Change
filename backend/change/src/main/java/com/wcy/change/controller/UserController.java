package com.wcy.change.controller;

import com.wcy.change.pojo.Users;
import com.wcy.change.mapper.UsersMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UsersMapper usersMapper;

    @RequestMapping(value = {"", "/"})
    public Users getUser(String id){
        return usersMapper.selectByPrimaryKey(id);
    }
}
