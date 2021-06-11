package BookingProcess;

import GoFo.*;
import UserManager.Player;
import java.util.ArrayList;

public class BookingManager
{
    private ArrayList<Book> bookings = new ArrayList<Book>();
    public ArrayList<Book> getBookings () { return  bookings; }

    /**
     * books a slot , add it to the bookings using player info,playground info and slot's info
     * @param player player who booked the playground
     * @param playground the booked playground
     * @param slot the booked slot
     * @param bookDate date on which a playground slot is booked
     * @return true when the process of booking a slot is completed
     */
    public boolean bookSlot(Player player, Playground playground, Slot slot, String bookDate)
    {
        Book book = new Book(player, playground, slot, bookDate);
        bookings.add(book);
        return true;
    }

    /**
     * cancels booking of the slot using the index of the slot then removing it.
     * @param index index of the booked slot
     * @return true when booking of a slot ix cancelled
     */
    public boolean cancelBooking(int index)
    {
        bookings.remove(index);
        return true;
    }

}

