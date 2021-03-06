package MenuSystem;

import UserSystem.*;

public class LoginMenu implements Menu
{
    /**
     *shows login menu.
     */
    public void Show ()
    {
        System.out.println("========= Login ========= ");
    }

    /**
     * Handles the process of logging in by asking the user for name and password then it checking their validity.
     * @return false if valid login, otherwise returns true.
     */
    public boolean Handle ()
    {
        String name = MenuManager.getStringWordInput("Enter username: ");
        String password = MenuManager.getStringWordInput("Enter password (case sensitive): ");

        LoginStatus loginStatus = UserManager.login(name, password);

        if(!loginStatus.isSuccessful) // Go back
        {
            System.out.println("Invalid login credentials");
            return true;
        }

        MenuManager.ignoreMenu(this);

        if(UserManager.getUser(loginStatus.userIndex).getType() == UserType.Player)
        {
            MenuManager.addMenu(new PlayerMenu(loginStatus.userIndex));
        }
        else if (UserManager.getUser(loginStatus.userIndex).getType() == UserType.PlaygroundOwner)
        {
            MenuManager.addMenu(new PlaygroundOwnerMenu(loginStatus.userIndex));
        }

        return false;
    }
}
