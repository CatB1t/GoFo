package MenuSystem;

public class LoginMenu implements Menu
{
    public void Show ()
    {
        String toPrint = "========= Login =========\n ";
        System.out.println(toPrint);
    }

    public boolean Handle ()
    {
        // TODO ask for input
        switch(MenuManager.getIntInput())
        {
            case 1: // Register
                // register menu
                return false;
            case 2: // Login
                // login menu
                return false;
            case 3: // Exit
                return true;
        }
        return true;
    }
}
