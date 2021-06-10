package UserManager;

public class LoginStatus
{
    public int userIndex;
    public boolean isSuccessful;

    /**
     *default constructor sets initial values for user index and validity of user info.
     */
    public LoginStatus()
    {
        userIndex = -1;
        isSuccessful = false;
    }

    /**
     *parametrized constructor sets value for user index and validity of user info.
     * @param index index of the user in Users arraylist.
     * @param valid boolean indicates whether user's name and password are valid or not.
     */
    public LoginStatus (int index, boolean valid)
    {
        userIndex = index;
        isSuccessful = valid;
    }
}
