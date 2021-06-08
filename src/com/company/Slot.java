package com.company;

import java.util.Date;

public class Slot {
    public String startTime;
    public String endTime;
    public Date date;
    public String dateString;
    //public Player
    public Slot(){
        this.startTime = "08:00";
        this.endTime = "00:00";
//        this.date = new Date("2021/06/08");
        this.dateString = "2021/06/08";
    }
    @Override
    public String toString(){

        return String.format(startTime + " till " + endTime +" on " + dateString);
    }
}
