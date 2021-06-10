package MenuSystem;

import UserManager.UserManager;
import com.sun.tools.javac.Main;

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
        name = MenuManager.keyboard.nextLine();
        System.out.print("Enter password (case sensitive): ");
        password = MenuManager.keyboard.nextLine();

        boolean isValidLogin = UserManager.login(name.toLowerCase(), password);

        if(!isValidLogin) // Go back
        {
            System.out.println("Invalid login credentials");
            return true;
        }

        // TODO Depending on role show menu

        MenuManager.addMenuToStack(new PlayerMenu());
        return false;
    }
}
