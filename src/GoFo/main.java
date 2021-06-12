package GoFo;

import MenuSystem.MainMenu;
import MenuSystem.MenuManager;
import UserManager.UserType;
import UserManager.UserManager;

public class main {
    public static void main(String[] args)
    {
        MenuManager Manager = new MenuManager();
        MenuManager.addMenu(new MainMenu());
        Manager.run();
    }
}
