package BookingProcess;

import com.company.Playground;
import com.company.Slot;
import com.company.UserManager.Player;

public class Book
{
    public Playground playground;
    public Player bookedByPlayer;
    public Slot bookedSlot;
    public String bookDate;

    Book (Player bookedByPlayer, Playground playground, Slot slot, String date)
    {
        this.playground = playground;
        this.bookedByPlayer = bookedByPlayer;
        this.bookedSlot = slot;
        this.bookDate = date;
    }

}
