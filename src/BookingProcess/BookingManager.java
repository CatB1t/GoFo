package BookingProcess;

import UserManager.Player;

import java.util.ArrayList;

public class BookingManager
{
    private ArrayList<Book> bookings = new ArrayList<Book>();
    public ArrayList<Book> getBookings () { return  bookings; }

    public boolean bookSlot(Player player, Playground playground, Slot slot, String bookDate)
    {
        Book book = new Book(player, playground, slot, bookDate);
        bookings.add(book);
        return true;
    }

    public boolean cancelBooking(int index)
    {
        bookings.remove(index);
        return true;
    }

}

