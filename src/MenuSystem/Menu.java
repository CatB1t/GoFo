package MenuSystem;

public interface Menu
{
    /**
     * Responsible for displaying the menu to the user
     */
    void Show();

    /**
     * Handles user's input
     * @return Should return true to exit the menu, otherwise returns false
     */
    boolean Handle();
}
