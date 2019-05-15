package com.wcy.change.controller;

import com.wcy.change.mapper.UserGoalMapper;
import com.wcy.change.mapper.UserWeeklyMapper;
import com.wcy.change.mapper.UsersMapper;
import com.wcy.change.pojo.Rank;
import com.wcy.change.pojo.UserWeekly;
import com.wcy.change.pojo.Users;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UsersMapper usersMapper;
    @Resource
    UserWeeklyMapper userWeeklyMapper;
    @Resource
    UserGoalMapper userGoalMapper;

    @RequestMapping(value = {"", "/"})
    public Users getUser(String id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/register")
    public boolean register(@RequestParam("name") String id, String password) {
        Users users = new Users();
        users.setUserid(id);
        users.setPassword(password);
        users.setName(id);
        return usersMapper.insertSelective(users) == 1;
    }

    @RequestMapping("/week")
    public UserWeekly week(String id) {
        return userWeeklyMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/update")
    public boolean update(@RequestBody Users users) {
        return usersMapper.updateByPrimaryKeySelective(users) == 1;
    }

    @RequestMapping("/allDay")
    public Rank allDay(String userid) {
        return userGoalMapper.selectTotal(userid);
    }
}
