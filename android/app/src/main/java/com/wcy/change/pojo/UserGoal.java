package com.wcy.change.pojo;

import java.util.Date;

public class UserGoal {
    private Integer goalid;

    private String userid;

    private Integer clockin;

    private Integer continuation;

    private Date startDate;

    private Date endDate;

    private String name;

    private String description;

    private Integer open;
    private Date lastDate;
    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
    public Integer getGoalid() {
        return goalid;
    }

    public void setGoalid(Integer goalid) {
        this.goalid = goalid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getClockin() {
        return clockin;
    }

    public void setClockin(Integer clockin) {
        this.clockin = clockin;
    }

    public Integer getContinuation() {
        return continuation;
    }

    public void setContinuation(Integer continuation) {
        this.continuation = continuation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }
}