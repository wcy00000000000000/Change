package com.wcy.change.pojo;

/**
 * Created by WCY on 2019/4/13
 */
public class UserGoal {
    private String userid;

    private Integer goalid;
    private Integer clockin;

    private Integer miss;

    private Integer continuation;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getGoalid() {
        return goalid;
    }

    public void setGoalid(Integer goalid) {
        this.goalid = goalid;
    }

    public Integer getClockin() {
        return clockin;
    }

    public void setClockin(Integer clockin) {
        this.clockin = clockin;
    }

    public Integer getMiss() {
        return miss;
    }

    public void setMiss(Integer miss) {
        this.miss = miss;
    }

    public Integer getContinuation() {
        return continuation;
    }

    public void setContinuation(Integer continuation) {
        this.continuation = continuation;
    }
}
