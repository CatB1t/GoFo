package BookingSystem;

import PlaygroundSystem.Playground;
import UserSystem.Player;

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

    /**
     * Displays simple information about the booked playground and day of booking.
     * @return name of the booked playground and date of booking.
     */
    public String simpleInfo()
    {
        return "Playground Name: " + playground.getName() + ", Date: " + bookedSlot.day;
    }

    /**
     * Displays detailed booking information.
     * @return String contains playground, name of the player who booked it, booked slot and booking date.
     */
    @Override
    public String toString()
    {
        return "Playground: " + playground + "Day: " + bookedSlot.day + "Start Time: " + bookedSlot.startTime + ". " + bookedSlot.endTime + ".";
    }
}
