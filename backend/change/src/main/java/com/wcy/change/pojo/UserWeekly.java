package com.wcy.change.pojo;

public class UserWeekly {
    private String userId;

    private Integer mon = 0;

    private Integer tue = 0;

    private Integer wed = 0;

    private Integer thur = 0;

    private Integer fri = 0;

    private Integer sat = 0;

    private Integer sun = 0;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getMon() {
        return mon;
    }

    public void setMon(Integer mon) {
        this.mon = mon;
    }

    public Integer getTue() {
        return tue;
    }

    public void setTue(Integer tue) {
        this.tue = tue;
    }

    public Integer getWed() {
        return wed;
    }

    public void setWed(Integer wed) {
        this.wed = wed;
    }

    public Integer getThur() {
        return thur;
    }

    public void setThur(Integer thur) {
        this.thur = thur;
    }

    public Integer getFri() {
        return fri;
    }

    public void setFri(Integer fri) {
        this.fri = fri;
    }

    public Integer getSat() {
        return sat;
    }

    public void setSat(Integer sat) {
        this.sat = sat;
    }

    public Integer getSun() {
        return sun;
    }

    public void setSun(Integer sun) {
        this.sun = sun;
    }
}