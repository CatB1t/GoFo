package MenuSystem;

/**
 * shows main menu for clients to choose what they want whether to register,log in or exit the whole app.
 */
public class MainMenu implements Menu
{
    public void Show ()
    {
        String toPrint = "========= GoFo =========\n" +
                "1. Register\n" +
                "2. Login\n" +
                "3. Exit\n";
        System.out.println(toPrint);
    }

    /**
     *Handles the user's choice whether they chose to log in, register or exit.
     * @return false when user chooses register or log in ,true when they decide to exit the app.
     */
    public boolean Handle ()
    {
        switch(MenuManager.getIntInput())
        {
            case 1: // Register
                MenuManager.addMenuToStack(new RegisterMenu());
                return false;
            case 2: // Login
                MenuManager.addMenuToStack(new LoginMenu());
                return false;
            case 3: // Exit
                return true;
        }
        return true;
    }
}
