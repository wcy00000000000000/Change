package com.wcy.change.pojo;

public class UserGoal extends UserGoalKey {
    private Integer clockin;

    private Integer miss;

    private Integer continuation;

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