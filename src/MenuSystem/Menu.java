package MenuSystem;

public interface Menu
{
    /**
     * Responsible for displaying different menus.
     */
    void Show();

    /**
     * Handles users' choices from menus.
     * @return boolean differs according to user's choice.
     */
    boolean Handle();
}
