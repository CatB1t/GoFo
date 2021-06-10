package MenuSystem;

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
