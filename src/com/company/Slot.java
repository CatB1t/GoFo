package com.company;

public class Slot
{
    public String startTime;
    public String endTime;
    public String day;

    public Slot(String start, String end, String day)
    {
        this.startTime = start;
        this.endTime = end;
        this.day = day;
    }

    @Override
    public String toString()
    {
        return String.format(startTime + " Till " + endTime +" On " + day);
    }
}
