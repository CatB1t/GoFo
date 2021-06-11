package MenuSystem;

import BookingProcess.Book;
import GoFo.Playground;
import GoFo.PlaygroundsManager;
import UserManager.PlaygroundOwner;
import UserManager.UserManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlaygroundOwnerMenu implements Menu
{
    private PlaygroundOwner currentUser;

    /**
     * parametrized constructor sets value for current user.
     * @param playgroundOwnerIndex index of the playground owner.
     */
    public PlaygroundOwnerMenu(int playgroundOwnerIndex)
    {
        currentUser = (PlaygroundOwner) UserManager.getUser(playgroundOwnerIndex);
    }

    /**
     *Displays menu for playground owners so they can choose to: add a new playground,show booking requests or exit the app.
     */

    public void Show ()
    {
        String toPrint = "========= Playground Owner Menu =========\n" +
                "Welcome Back " + currentUser.getName() + "!\n" +
                "1. Create playground\n" +
                "2. Show playgrounds\n" +
                "3. Logout\n";
        System.out.println(toPrint);
    }

    /**
     *Handles the playground owner's choice from menu.
     * @return boolean equals true when playground owner choose to add new play ground or show bookings, and false when they exit the app.
     */
    public boolean Handle ()
    {
        switch(MenuManager.getIntInput())
        {
            case 1: // Create
                createPlayground();
                return false;
            case 2: // Show Playgrounds
                showPlaygrounds();
                return false;
            case 3: // Exit
                return true;
            default:
                System.out.println("Invalid input");
                return false;
        }
    }

    /**
     * Creates a new playground using data taken from playground owner.
     * @return true after creating the new playground successfully.
     */
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

    private void showPlaygrounds()
    {
        ArrayList<Playground> playgrounds = currentUser.getOwnedPlaygrounds();

        if(playgrounds.isEmpty())
        {
            System.out.println("No available playgrounds to show.");
            return;
        }

        String toPrint = "";
        for(int i = 0; i < playgrounds.size(); i++)
        {
            toPrint += "" + (i + 1) + ". " + playgrounds.get(i).getName() + "\n";
        }

        toPrint += (playgrounds.size() + 1) + ". Return";
        System.out.println(toPrint);

        int choice = MenuManager.getIntInput();
        // TODO loop for valid input
        if(choice < 1 || choice > playgrounds.size())
        {
            System.out.println("Invalid Input");
            return;
        }

        if(choice == playgrounds.size() + 1)
            return;

        MenuManager.addMenuToStack(new PlaygroundManageMenu(playgrounds.get(choice - 1)));
    }

    /**
     * Shows all the playgrounds and displays a message to inform the playground owner if there is not any bookings.
     */
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
            toPrint = "" + i + ". " + myBookings.get(i).simpleInfo() + "\n";
        }

        System.out.println(toPrint);
    }
}
