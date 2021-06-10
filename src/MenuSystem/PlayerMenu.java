package MenuSystem;

public class PlayerMenu implements Menu
{
    public void Show ()
    {
        String toPrint = "========= Player Menu =========\n" +
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
