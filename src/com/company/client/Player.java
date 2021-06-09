package com.company.client;

import BookingProcess.Book;

import java.util.ArrayList;

public class Player
{
    private ArrayList<Book> bookings =  new ArrayList<Book>();

    public ArrayList<Book> getAllBookings(){
        return bookings;
    }
    public Book getBooking(int index){
        return bookings.get(index);
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
