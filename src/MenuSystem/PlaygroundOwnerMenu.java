package MenuSystem;

import UserManager.User;
import UserManager.UserManager;


public class PlaygroundOwnerMenu implements Menu
{
    private User currentUser;

    /**
     *
     * @param playerIndex
     */
    public PlaygroundOwnerMenu(int playerIndex)
    {
        currentUser = UserManager.getUser(playerIndex);
    }

    /**
     *Displays menu for playground owners so they can choose to: add a new playground,show booking requests or exit the app.
     */

    public void Show ()
    {
        String toPrint = "========= Playground Owner Menu =========\n" +
                "Welcome Back " + currentUser.getName() + "!\n" +
                "1. Add playground\n" +
                "2. Show booking requests\n" +
                "3. Exit\n";
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
            case 1: // Add
                return false;
            case 2: // Show Booking
                return false;
            case 3: // Exit
                return true;
        }
        return true;
    }
}
