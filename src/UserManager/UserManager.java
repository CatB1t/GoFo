package UserManager;

import java.util.ArrayList;

public class UserManager {

    static private ArrayList<User> registeredUsers = new ArrayList<User>();

    static public boolean createUser(String name,  String password, String email, String number, String location, UserType type)
    {
        // TODO Check for valid user
        User tmp;
        if(type == UserType.PlaygroundOwner)
            tmp = new PlaygroundOwner(name, password, email, number, location, type);
        else
            tmp = new Player(name, password, email, number, location, type);

        registeredUsers.add(tmp);
        return true;
    }

    static public LoginStatus login (String name, String password)
    {
        for(int i = 0; i < registeredUsers.size(); i++)
        {
            User cached = registeredUsers.get(i);
            if(cached.verify(name, password)) {
                return new LoginStatus(i, true);
            }
        }
        return new LoginStatus(-1, false);
    }

    static public User getUser(int index)
    {
        return registeredUsers.get(index);
    }
}
