package com.wcy.change.dao;

import com.wcy.change.pojo.User;

import java.util.List;

/**
 * Created by WCY on 2019/4/13
 */
public interface UserDao {
    User getUser(String userId);

    boolean insertUser(User obj);
}
