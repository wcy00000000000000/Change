package com.wcy.change.dao;

import com.wcy.change.pojo.UserGoal;

import java.util.List;

public interface UserGoalDao {
    List<UserGoal> findAllGoal(String userid);
    UserGoal findGoalById(String goalid);
    boolean checkin(String goalid);
    boolean update(UserGoal obj);
    boolean insertUserGoal(UserGoal obj);
}
