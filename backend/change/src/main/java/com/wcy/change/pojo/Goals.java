package com.wcy.change.pojo;

public class Goals {
    private Integer goalid;

    private String name;

    private String description;

    private String frequency;

    public Integer getGoalid() {
        return goalid;
    }

    public void setGoalid(Integer goalid) {
        this.goalid = goalid;
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

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }
}