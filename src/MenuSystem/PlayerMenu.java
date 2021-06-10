package MenuSystem;

import UserManager.User;
import UserManager.UserManager;

public class PlayerMenu implements Menu
{
    private User currentUser;

    /**
     * sets the current user to the player using menu.
     * @param playerIndex index of the player who will use the menu
     */
    public PlayerMenu(int playerIndex)
    {
        currentUser = UserManager.getUser(playerIndex);
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
                "3. Exit\n";
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
                return false;
            case 2: // Show bookings
                return false;
            case 3: // Exit
                return true;
        }
        return true;
    }
}
