package MenuSystem;

import UserManager.User;
import UserManager.UserManager;

public class RegisterMenu implements Menu
{
    public void Show ()
    {
        String toPrint = "========= Register =========\n " +
                "Choose the role:\n" +
                "1. Playground Owner\n" +
                "2. Playground\n" +
                "3. Return\n";
        System.out.println(toPrint);
    }

    public boolean Handle ()
    {
        switch(MenuManager.getIntInput())
        {
            case 1: // Playground Owner
                createUser(User.UserType.PlaygroundOwner);
                MenuManager.ignoreMenuInStack(this);
                MenuManager.addMenuToStack(new LoginMenu());
                return false;
            case 2: // Playground
                createUser(User.UserType.Player);
                MenuManager.ignoreMenuInStack(this);
                MenuManager.addMenuToStack(new LoginMenu());
                return false;
            case 3: // Return
                return true;
        }
        return false;
    }

    private boolean createUser (User.UserType type)
    {
        MenuManager.clearBuffer();
        String name, password, email, location, phone;

        System.out.print("Enter your username: ");
        name = MenuManager.keyboard.nextLine();

        System.out.print("Enter your password: ");
        password = MenuManager.keyboard.nextLine();

        System.out.print("Enter your email: ");
        email = MenuManager.keyboard.nextLine();

        System.out.print("Enter your phone: ");
        phone = MenuManager.keyboard.nextLine();

        System.out.print("Enter your location: ");
        location = MenuManager.keyboard.nextLine();

        UserManager.createUser(name, password, email, phone, location, type);
        return true;
    }
}
