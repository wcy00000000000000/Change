package com.wcy.change.controller;

import com.wcy.change.mapper.UserGoalMapper;
import com.wcy.change.mapper.UserWeeklyMapper;
import com.wcy.change.pojo.UserGoal;
import com.wcy.change.pojo.UserGoalExample;
import com.wcy.change.pojo.UserWeekly;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/goal")
public class GoalController {
    @Resource
    UserGoalMapper userGoalMapper;
    @Resource
    UserWeeklyMapper userWeeklyMapper;

    @RequestMapping("/find")
    public List<UserGoal> find(String id) {
        updateWeekly(id);
        UserGoalExample userGoalExample = new UserGoalExample();
        UserGoalExample.Criteria criteria = userGoalExample.createCriteria();
        criteria.andUseridEqualTo(id);
        return userGoalMapper.selectByExample(userGoalExample);
    }

    @RequestMapping("/findGoalById")
    public UserGoal findGoalById(int id) {
        return userGoalMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/insert")
    public boolean insert(@RequestBody UserGoal userGoal) {
        return userGoalMapper.insertSelective(userGoal) == 1;
    }

    @RequestMapping("/update")
    public boolean update(@RequestBody UserGoal userGoal) {
        return userGoalMapper.updateByPrimaryKeySelective(userGoal) == 1;
    }

    @RequestMapping("/checkin")
    public boolean checkin(int goalid) {
        UserGoal userGoal = userGoalMapper.selectByPrimaryKey(goalid);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        if(userGoal.getLastDate()!=null && userGoal.getLastDate().equals(calendar.getTime())){
            userGoal.setContinuation(userGoal.getContinuation() + 1);
        }
        userGoal.setLastDate(new Date());
        userGoal.setClockin(userGoal.getClockin() + 1);
        updateWeekly(userGoal.getUserid());
        return userGoalMapper.updateByPrimaryKeySelective(userGoal) == 1;
    }

    public void updateWeekly(String id){
        UserWeekly cur = userWeeklyMapper.selectByPrimaryKey(id);
        UserWeekly userWeekly = new UserWeekly();
        userWeekly.setUserId(cur.getUserId());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        UserGoalExample userGoalExample = new UserGoalExample();
        UserGoalExample.Criteria criteria = userGoalExample.createCriteria();
        criteria.andUseridEqualTo(id);
        criteria.andLastDateEqualTo(new Date());
        List<UserGoal> userGoals = userGoalMapper.selectByExample(userGoalExample);
        int count = userGoals.size();
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                userWeekly.setSun(count);
                break;
            case 2:
                userWeekly.setSun(cur.getSun());
                userWeekly.setMon(count);
                break;
            case 3:
                userWeekly.setSun(cur.getSun());
                userWeekly.setMon(cur.getMon());
                userWeekly.setTue(count);
                break;
            case 4:
                userWeekly.setSun(cur.getSun());
                userWeekly.setMon(cur.getMon());
                userWeekly.setTue(cur.getTue());
                userWeekly.setWed(count);
                break;
            case 5:
                userWeekly = cur;
                userWeekly.setThur(count);
                userWeekly.setFri(0);
                userWeekly.setSat(0);
                break;
            case 6:
                userWeekly = cur;
                userWeekly.setFri(count);
                userWeekly.setSat(0);
                break;
            case 7:
                userWeekly = cur;
                userWeekly.setSat(count);
                break;
        }
        userWeeklyMapper.updateByPrimaryKey(userWeekly);
    }
}
