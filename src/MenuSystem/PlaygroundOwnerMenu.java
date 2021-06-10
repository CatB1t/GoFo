package MenuSystem;

import UserManager.User;
import UserManager.UserManager;

public class PlaygroundOwnerMenu implements Menu
{
    private User currentUser;

    public PlaygroundOwnerMenu(int playerIndex)
    {
        currentUser = UserManager.getUser(playerIndex);
    }

    public void Show ()
    {
        String toPrint = "========= Playground Owner Menu =========\n" +
                "Welcome Back " + currentUser.getName() + "!\n" +
                "1. Add playground\n" +
                "2. Show booking requests\n" +
                "3. Exit\n";
        System.out.println(toPrint);
    }

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
