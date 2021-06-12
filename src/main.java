import MenuSystem.MainMenu;
import MenuSystem.MenuManager;

public class main {
    public static void main(String[] args)
    {
        MenuManager Manager = new MenuManager();
        MenuManager.addMenu(new MainMenu());
        Manager.run();
    }
}
