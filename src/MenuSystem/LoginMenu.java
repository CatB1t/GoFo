package MenuSystem;

import UserManager.*;

public class LoginMenu implements Menu
{
    public void Show ()
    {
        System.out.println("========= Login ========= ");
    }

    public boolean Handle ()
    {
        String name,password;

        System.out.print("Enter username: ");
        name = MenuManager.keyboard.next();
        System.out.print("Enter password (case sensitive): ");
        password = MenuManager.keyboard.next();

        LoginStatus loginStatus = UserManager.login(name, password);

        if(!loginStatus.isSuccessful) // Go back
        {
            System.out.println("Invalid login credentials");
            return true;
        }

        MenuManager.ignoreMenuInStack(this);

        if(UserManager.getUser(loginStatus.userIndex).getType() == UserType.Player)
        {
            MenuManager.addMenuToStack(new PlayerMenu(loginStatus.userIndex));
        }
        else if (UserManager.getUser(loginStatus.userIndex).getType() == UserType.PlaygroundOwner)
        {
            MenuManager.addMenuToStack(new PlaygroundOwnerMenu(loginStatus.userIndex));
        }

        return false;
    }
}
