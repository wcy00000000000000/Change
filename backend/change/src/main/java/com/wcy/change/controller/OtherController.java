package com.wcy.change.controller;

import com.wcy.change.mapper.UserGoalMapper;
import com.wcy.change.pojo.Rank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OtherController {
    @Resource
    UserGoalMapper userGoalMapper;

    @RequestMapping("/rank")
    public List<Rank> rank() {
        return userGoalMapper.selectByRank().subList(0, 3);
    }

    @RequestMapping("/userRank")
    public int userRank(String userid) {
        int i = 1;
        List<Rank> rankList = userGoalMapper.selectByRank();
        for (Rank rank : rankList) {
            if (rank.getName().equals(userid)) {
                return i;
            }
            i++;
        }
        return i;
    }

    @RequestMapping("/userCount")
    public int userCount(String userid) {
        List<Rank> rankList = userGoalMapper.selectByRank();
        for (Rank rank : rankList) {
            if (rank.getName().equals(userid)) {
                return rank.getCount();
            }
        }
        return -1;
    }
}
