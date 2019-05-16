package com.wcy.change.util;


import com.wcy.change.pojo.User;
import com.wcy.change.pojo.UserGoal;
import com.wcy.change.util.datepicker.DateFormatUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessGoalList {
    private static List<UserGoal> todayList;
    private static List<UserGoal> weekList;
    private static List<UserGoal> overdueList;

    public static void distinguish(List<UserGoal> list){
        todayList=new ArrayList<>();
        weekList=new ArrayList<>();
        overdueList=new ArrayList<>();
        for (UserGoal goal:list){
            Date start = goal.getStartDate();
            Date end = goal.getEndDate();
            long beginTimestamp  = DateFormatUtils.str2Long(DateFormatUtils.long2Str(start.getTime(),false), false);
            long endTimestamp = DateFormatUtils.str2Long(DateFormatUtils.long2Str(end.getTime(),false), false);
            long current = System.currentTimeMillis();
            long currentDay = DateFormatUtils.str2Long(DateFormatUtils.long2Str(current,false), false);

            if (beginTimestamp<=currentDay && endTimestamp>=currentDay){
                todayList.add(goal);
            }
            long weekago=currentDay-7*86400000L;//1天的时间=24小时 x 60分钟 x 60秒 x 1000毫秒 单位是L, 7天.
            if (endTimestamp>=weekago && beginTimestamp<=currentDay){
                //当前时间在开始时间之后，截止时间在7天前
                weekList.add(goal);
            }

            if (endTimestamp<currentDay){
                overdueList.add(goal);
            }

        }
    }

    public static boolean isCheckedToday(UserGoal goal){
        //检查最后打卡时间是否今天，去掉date的时分
        boolean flag =false;
        Date lastDate = goal.getLastDate();
        long last=0;
        if (lastDate!=null){
            last = lastDate.getTime();
        }
        last = DateFormatUtils.str2Long(DateFormatUtils.long2Str(last,false), false);

        long current = System.currentTimeMillis();

        long currentDay = DateFormatUtils.str2Long(DateFormatUtils.long2Str(current,false), false);

        if (last==currentDay)
            flag= true;
        return flag;
    }

    //今日完成数
    public static int isFinishedToday(List<UserGoal> list){
        int count =0;
        for (UserGoal goal : list){
            if (isCheckedToday(goal)){
                count++;
            }
        }
        return count;
    }

    //是否是今日任务
    public static boolean isTodayGoal(String goalid){
        for (UserGoal goal: getTodayGoalList()){
            if (goal.getGoalid().toString().equals(goalid))
                return true;
        }
        return false;
    }
    //是否已过期
    public static boolean isOverdueGoal(String goalid){
        for (UserGoal goal: getOverdueList()){
            if (goal.getGoalid().toString().equals(goalid))
                return true;
        }
        return false;
    }

    public static List<UserGoal> getTodayGoalList(){
        return todayList;
    }
    public static List<UserGoal> getWeekGoalList(){
        return weekList;
    }
    public static List<UserGoal> getOverdueList(){
        return overdueList;
    }
}
