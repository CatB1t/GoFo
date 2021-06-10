package GoFo;

import MenuSystem.MainMenu;
import MenuSystem.MenuManager;

public class main {
    public static void main(String[] args)
    {
        MenuManager Manager = new MenuManager();
        MenuManager.addMenuToStack(new MainMenu());
        Manager.run();
    }
}
