package BookingProcess;

import com.company.Playground;
import com.company.Slot;
import com.company.client.*;

import java.util.ArrayList;
import java.util.Date;

public class Book { //TODO complete
    public enum BookStatus{accepted,denied,cancelled,pending}

    public Playground playground;
    public Player bookedByPlayer;
    public Slot bookedSlot;
    public String bookDate;

    public BookStatus status;



}
