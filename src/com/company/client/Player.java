package com.company.client;

import BookingProcess.Book;

import java.util.ArrayList;

public class Player {
    private ArrayList<Book> Bookings =  new ArrayList<Book>();
    //private Wallet wallet; //TODO remove wallet classes
    // public void complaint(){} //TODO remove complaint classes

    public ArrayList<Book> getAllBookings(){
        return Bookings;
    }
    public Book getBooking(int index){
        return Bookings.get(index);
    }
    public Book.BookStatus getBookingStatus(Book book){ //changed from update to get because no update?
        return book.status;
    }
    public void addBooking(Book book){
        Bookings.add(book);
    }
}
