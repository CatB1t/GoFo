package MenuSystem;

import UserManager.User;
import UserManager.UserManager;

public class PlayerMenu implements Menu
{
    private User currentUser;

    public PlayerMenu(int playerIndex)
    {
        currentUser = UserManager.getUser(playerIndex);
    }

    public void Show ()
    {
        String toPrint = "========= Player Menu =========\n" +
                "Welcome Back " + currentUser.getName() + "!\n" +
                "1. Show playgrounds\n" +
                "2. Show my bookings\n" +
                "3. Exit\n";
        System.out.println(toPrint);
    }

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
