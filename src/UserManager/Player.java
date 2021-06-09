package UserManager;

import BookingProcess.Book;

import java.util.ArrayList;

public class Player extends User
{
    private ArrayList<Book> bookings =  new ArrayList<Book>();

    public ArrayList<Book> getAllBookings() { return bookings; }
    public Book getBooking(int index){ return bookings.get(index); }

    public Player (String name, String password, String email, String phone, String location, UserType type)
    {
        super(name, password, email, phone, location, UserType.Player);
    }

    public void addBooking(Book book)
    {
        bookings.add(book);
    }

    public void cancelBooking(int index)
    {
        bookings.remove(index);
    }
}
