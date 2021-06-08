package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Playground {
    private String name;
    private int size;
    private String location;
    private long pricePerHour;
    public ArrayList<Slot> schedule = new ArrayList<Slot>(); //changed to public by dova

    private int cancellationPeriod;
    private boolean isActive;
    //private PlaygroundOwner owner;
    //ArrayList<Book> pendingRequests;
    public Playground(){
        this.name = "barca";
        this.size = 10;
        this.location = "faisal";
        this.pricePerHour = (long) 100.0;

    }
    public void addSlot(String start, String end,String date){ //TODO add Date parameter
        Slot slot = new Slot();
        slot.startTime = start;
        slot.endTime = end;
        slot.dateString = date;
//        slot.date = new Date(date);
        schedule.add(slot);
    }
    public void getSlots(){
        for (int i = 0; i < schedule.size(); i++) {
            System.out.println(schedule.get(i));
        }
    }

}
