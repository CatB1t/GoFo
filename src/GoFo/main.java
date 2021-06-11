package GoFo;

import MenuSystem.MainMenu;
import MenuSystem.MenuManager;
import UserManager.UserType;
import UserManager.UserManager;

public class main {
    public static void main(String[] args)
    {

        UserManager.createUser("b", "b", "", "", "", UserType.PlaygroundOwner); // for test
        UserManager.createUser("d", "d", "", "", "", UserType.Player); // for test

        MenuManager Manager = new MenuManager();
        MenuManager.addMenuToStack(new MainMenu());
        Manager.run();
    }
}
