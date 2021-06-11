package BookingProcess;

import GoFo.Playground;
import GoFo.Slot;
import UserManager.Player;

public class Book
{

    public Playground playground;
    public Player bookedByPlayer;
    public Slot bookedSlot;

    /**
     * sets booking information
     * @param bookedByPlayer player who booked the playground
     * @param playground the booked playground
     * @param slot the booked slot
     */
    Book (Player bookedByPlayer, Playground playground, Slot slot)
    {
        this.playground = playground;
        this.bookedByPlayer = bookedByPlayer;
        this.bookedSlot = slot;
    }

    public String simpleInfo()
    {
        return "Playground Name: " + playground.getName() + ", Date: " + bookedSlot.day;
    }

    @Override
    public String toString() {
        return "Book{" +
                "playground=" + playground +
                ", bookedByPlayer=" + bookedByPlayer +
                ", bookedSlot=" + bookedSlot +
                '}';
    }
}
