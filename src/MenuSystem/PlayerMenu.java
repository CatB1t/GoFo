package MenuSystem;

import BookingProcess.Book;
import GoFo.Playground;
import GoFo.PlaygroundsManager;
import UserManager.UserManager;
import UserManager.Player;

import java.util.ArrayList;

public class PlayerMenu implements Menu
{
    private Player currentUser;

    public PlayerMenu(int playerIndex)
    {
        currentUser = (Player) UserManager.getUser(playerIndex);
    }

    public void Show ()
    {
        String toPrint = "========= Player Menu =========\n" +
                "Welcome Back " + currentUser.getName() + "!\n" +
                "1. Show playgrounds\n" +
                "2. Show my bookings\n" +
                "3. Logout\n";
        System.out.println(toPrint);
    }

    public boolean Handle ()
    {
        switch(MenuManager.getIntInput())
        {
            case 1: // Show playgrounds
                showAvailablePlaygrounds();
                return false;
            case 2: // Show bookings
                showMyBookings();
                return false;
            case 3: // Exit
                return true;
        }
        return true;
    }

    private void showMyBookings ()
    {
        ArrayList<Book> myBookings = currentUser.getAllBookings();

        if(myBookings.size() <= 0)
        {
            System.out.println("There's no bookings available to show.");
            return;
        }

        String toPrint = "";
        for(int i = 0; i < myBookings.size(); ++i)
        {
            Book cached = myBookings.get(i);
            toPrint = "" + i +
            cached.bookDate + "\n" +
            ", " + cached.playground;
            System.out.println(toPrint);
        }
    }

    private void showAvailablePlaygrounds()
    {
        ArrayList<Playground> playgrounds = PlaygroundsManager.getPlaygrounds();

        if(playgrounds.size() <= 0)
        {
            System.out.println("There's no playgrounds available to show.");
            return;
        }

        String toPrint = "";
        for(int i = 0; i < playgrounds.size(); i++)
        {
            Playground cached = playgrounds.get(i);
            toPrint = "" + i + cached.getName();
            System.out.println(toPrint);
        }
    }
}
