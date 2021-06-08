package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Book { //TODO complete
    private enum BookStatus{Accepted,Denied,Cancelled,Pending}
    private ArrayList<Integer> slotIndex = new ArrayList<Integer>();
    private Playground playground;
    private Player bookedByPlayer;
    private BookStatus status;
    private Date bookDate;
}
