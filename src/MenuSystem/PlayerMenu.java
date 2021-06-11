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

    /**
     * sets the current user to the player using menu.
     * @param playerIndex index of the player who will use the menu
     */
    public PlayerMenu(int playerIndex)
    {
        currentUser = (Player) UserManager.getUser(playerIndex);
    }

    /**
     *shows the player menu that contains: show playgrounds,show player's bookings and exit the app.
     */
    public void Show ()
    {
        String toPrint = "========= Player Menu =========\n" +
                "Welcome Back " + currentUser.getName() + "!\n" +
                "1. Show playgrounds\n" +
                "2. Show my bookings\n" +
                "3. Logout\n";
        System.out.println(toPrint);
    }

    /**
     *Handles player's choice whether they chose to show playground,show bookings, or to exit the app.
     * @return false when player chooses to show playgrounds or bookings,and return true when he exits.
     */

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

    /**
     * Shows all the player's booking and if there is not any bookings it displays a message to inform the player.
     */
    private void showMyBookings ()
    {
        ArrayList<Book> myBookings = currentUser.getAllBookings();

        if(myBookings.isEmpty())
        {
            System.out.println("There's no bookings available to show.");
            return;
        }

        String toPrint = "";
        for(int i = 0; i < myBookings.size(); ++i)
        {
            Book cached = myBookings.get(i);
            toPrint += (i + 1) + "Day: " + cached.bookedSlot.day + ", Playground: " + cached.playground.getName() + "\n";
        }

        System.out.println(toPrint);
    }

    /**
     * Shows all available playgrounds for booking and if there is not any available ones it displays a message to inform the player.
     */
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
            toPrint += (i + 1) + ". " + cached.getName() + "\n";
        }

        toPrint += (playgrounds.size() + 1) + ". Return";
        System.out.println(toPrint);

        // TODO handle input
        int choice = MenuManager.getIntInput();

        // TODO Loop for valid input
        if(choice < 1 || choice > (playgrounds.size() + 1))
        {
            System.out.println("Invalid input");
            return;
        }

        if(choice == (playgrounds.size() + 1)) {
            return;
        }

        MenuManager.addMenuToStack(new BookPlaygroundMenu(choice - 1, currentUser));
    }
}
