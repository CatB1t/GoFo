package UserManager;

public class LoginStatus
{
    public int userIndex;
    public boolean isSuccessful;

    public LoginStatus()
    {
        userIndex = -1;
        isSuccessful = false;
    }

    public LoginStatus (int index, boolean valid)
    {
        userIndex = index;
        isSuccessful = valid;
    }
}
