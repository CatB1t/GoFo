package BookingProcess;

import PlaygroundSystem.Playground;
import UserSystem.Player;
import java.util.ArrayList;

public class BookingManager
{
    static private ArrayList<Book> bookings = new ArrayList<Book>();

    /**
     * Gets all bookings.
     * @return bookings.
     */
    static public ArrayList<Book> getBookings () { return  bookings; }

    /**
     * books a slot , add it to the bookings using player info,playground info and slot's info
     * @param player player who booked the playground
     * @param playground the booked playground
     * @param slot the booked slot
     * @return true when the process of booking a slot is completed
     */
    static public boolean bookSlot(Player player, Playground playground, Slot slot)
    {
        Book book = new Book(player, playground, slot);
        bookings.add(book);
        player.addBooking(book); // Notify player
        playground.bookSlot(slot); // Notify playground
        return true;
    }

    /**
     * cancels booking of the slot using the index of the slot then removing it.
     * @param index index of the booked slot
     * @return true when booking of a slot ix cancelled
     */
    static public boolean cancelBooking(int index)
    {
        bookings.remove(index);
        return true;
    }

}

