package BookingProcess;

import com.company.Playground;
import com.company.client.*;

import java.util.ArrayList;
import java.util.Date;

public class Book extends BookingManager { //TODO complete
    public enum BookStatus{accepted,denied,cancelled,pending}
    private ArrayList<Book> bookings = new ArrayList<Book>();
    private Playground playground;
    private Player bookedByPlayer;
    private Date bookDate;

    public BookStatus status;


}
