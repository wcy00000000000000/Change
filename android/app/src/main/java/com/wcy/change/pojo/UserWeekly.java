package com.wcy.change.pojo;

public class UserWeekly {
    private String userId;

    private Integer mon;

    private Integer tue;

    private Integer wed;

    private Integer thur;

    private Integer fri;

    private Integer sat;

    private Integer sun;

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