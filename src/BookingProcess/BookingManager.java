package BookingProcess;

import com.company.*;
import com.company.client.*;

import java.util.ArrayList;

public class BookingManager extends Book { //TODO complete
    private ArrayList<Book> Bookings = new ArrayList<>();

    public boolean bookSlot(Player player,Playground playground,Slot slot,String bookDate){ //TODO check return
        Book book = new Book();
        book.bookedByPlayer = player;
        book.playground = playground;
        book.bookedSlot = slot;
        book.bookDate = bookDate;
        Bookings.add(book);
        return true;
    }
//    private void updateBookingStatus(Player player, Playground playground, ArrayList<Book> bookings){//TODO check parameters
//
//    }

    public boolean cancelBooking(int index){ //TODO check return
        Bookings.remove(index);
        return true;
    }



}

