package UserManager;

import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> registeredUsers = new ArrayList<User>();

    public boolean createUser(String name,  String password, String email, String number, String location, User.UserType type)
    {
        // TODO Check for valid user
        User tmp = new User(name, password, email, number, location, type);
        registeredUsers.add(tmp);
        return true;
    }

    public boolean login (String name, String password)
    {
        for(int i = 0; i < registeredUsers.size(); i++)
        {
            User cached = registeredUsers.get(i);
            if(cached.verify(name, password))
                return true;
        }
        return false;
    }
}
