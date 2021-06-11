package BookingProcess;

import GoFo.Playground;
import GoFo.Slot;
import UserManager.Player;

public class Book
{

    public Playground playground;
    public Player bookedByPlayer;
    public Slot bookedSlot;
    public String bookDate;

    /**
     * sets booking information
     * @param bookedByPlayer player who booked the playground
     * @param playground the booked playground
     * @param slot the booked slot
     * @param date date on which a playground slot is booked
     */
    Book (Player bookedByPlayer, Playground playground, Slot slot, String date)
    {
        this.playground = playground;
        this.bookedByPlayer = bookedByPlayer;
        this.bookedSlot = slot;
        this.bookDate = date;
    }

    public String simpleInfo()
    {
        return "Playground Name: " + playground.getName() + ", Date: " + bookDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "playground=" + playground +
                ", bookedByPlayer=" + bookedByPlayer +
                ", bookedSlot=" + bookedSlot +
                ", bookDate='" + bookDate + '\'' +
                '}';
    }
}
