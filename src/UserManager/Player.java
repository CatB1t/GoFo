package UserManager;

import BookingProcess.Book;

import java.util.ArrayList;

public class Player extends User
{
    private ArrayList<Book> bookings =  new ArrayList<Book>();

    /**
     *gets all the player's bookings.
     * @return Arraylist contains all player's bookings.
     */
    public ArrayList<Book> getAllBookings() { return bookings; }

    /**
     *get a selected book by it's index.
     * @param index The index of the selected booking in the arraylist of bookings.
     * @return the selected booking.
     */
    public Book getBooking(int index){ return bookings.get(index); }

    /**
     *parametrized constructor sets the player's information.
     * @param name name of the player.
     * @param password password that player creates for his profile.
     * @param email the player's email.
     * @param phone the player's phone number.
     * @param location the player's location.
     */
    public Player (String name, String password, String email, String phone, String location)
    {
        super(name, password, email, phone, location, UserType.Player);
    }

    /**
     *Add new book to bookings.
     * @param book the newly added book.
     */
    public void addBooking(Book book)
    {
        bookings.add(book);
    }

    /**
     *Cancels booking using it's index then removing it from bookings arraylist.
     * @param index index of the booking the player want to cancel.
     */
    public void cancelBooking(int index)
    {
        bookings.remove(index);
    }
}
