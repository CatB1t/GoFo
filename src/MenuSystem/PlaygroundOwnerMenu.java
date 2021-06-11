package MenuSystem;

import BookingProcess.Book;
import GoFo.PlaygroundsManager;
import UserManager.PlaygroundOwner;
import UserManager.UserManager;

import java.util.ArrayList;

public class PlaygroundOwnerMenu implements Menu
{
    private PlaygroundOwner currentUser;

    public PlaygroundOwnerMenu(int playerIndex)
    {
        currentUser = (PlaygroundOwner) UserManager.getUser(playerIndex);
    }

    public void Show ()
    {
        String toPrint = "========= Playground Owner Menu =========\n" +
                "Welcome Back " + currentUser.getName() + "!\n" +
                "1. Create playground\n" +
                "2. Show booking requests\n" +
                "3. Logout\n";
        System.out.println(toPrint);
    }

    public boolean Handle ()
    {
        switch(MenuManager.getIntInput())
        {
            case 1: // Create
                createPlayground();
                return false;
            case 2: // Show Booking
                showBookings();
                return false;
            case 3: // Exit
                return true;
        }
        return true;
    }

    private boolean createPlayground()
    {

        MenuManager.clearBuffer();

        System.out.print("Enter playground name: ");
        String name = MenuManager.getStringLineInput();

        System.out.print("Enter location name: ");
        String location = MenuManager.getStringLineInput();

        int size = MenuManager.getIntInput("Enter playground size: ");

        System.out.print("Enter price per hour: ");
        long price = MenuManager.getIntInput(); // TODO use double price

        currentUser.createPlayground(name, location, size, price);
        return true;
    }

    private void showBookings ()
    {
        ArrayList<Book> myBookings = new ArrayList<Book>();

        if(myBookings.size() <= 0)
        {
            System.out.println("No available bookings to show.");
            return;
        }

        String toPrint = "";
        for(int i = 0; i < myBookings.size(); i++)
        {
            toPrint = "" + i + ". " + myBookings.get(i).simpleInfo();
        }

        // TODO handle
    }
}
