package MenuSystem;

import UserManager.UserType;
import UserManager.UserManager;

public class RegisterMenu implements Menu
{
    /**
     *Shows a menu contains available user types: player and Playground owner.
     */
    public void Show ()
    {
        String toPrint = "========= Register =========\n" +
                "Choose the role:\n" +
                "1. Player\n" +
                "2. Playground Owner\n" +
                "3. Return\n";
        System.out.println(toPrint);
    }

    /**
     *Handles user's choice as it sets user's type to register them.
     * @return false when user chose either player or owner,and true if the decided to go back to the previous page.
     */
    public boolean Handle ()
    {
        switch(MenuManager.getInputChoice(1,3))
        {
            case 1: // Player
                createUser(UserType.Player);
                MenuManager.ignoreMenuInStack(this);
                MenuManager.addMenuToStack(new LoginMenu());
                return false;
            case 2: // Playground Owner
                createUser(UserType.PlaygroundOwner);
                MenuManager.ignoreMenuInStack(this);
                MenuManager.addMenuToStack(new LoginMenu());
                return false;
            case 3: // Return
                return true;
        }
        return false;
    }

    /**
     *creates a new user according to their type,using data taken from users as input.
     * @param type user type whether they are players or playgrounds user.
     * @return true when the process of creating a new user is complete.
     */
    private boolean createUser (UserType type)
    {

        String name, password, email, location, phone;

        System.out.print("Enter your username: ");
        name = MenuManager.keyboard.next();

        System.out.print("Enter your password: ");
        password = MenuManager.keyboard.next();

        System.out.print("Enter your email: ");
        email = MenuManager.keyboard.next();

        System.out.print("Enter your phone: ");
        phone = MenuManager.keyboard.next();

        System.out.print("Enter your location: ");
        MenuManager.clearBuffer();
        location = MenuManager.keyboard.nextLine();

        if(UserManager.createUser(name, password, email, phone, location, type))
        {
            System.out.println("Registered successfully");
        }
        else {
            System.out.println("User already exist");
        }

        return true;
    }
}
