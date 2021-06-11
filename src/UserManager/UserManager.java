package UserManager;

import java.util.ArrayList;

public class UserManager {

    static private ArrayList<User> registeredUsers = new ArrayList<User>();

    /**
     *creates users using their information.
     * @param name name of the user.
     * @param password password of the user.
     * @param email email of the user.
     * @param number phone number of the user.
     * @param location location of the user.
     * @param type type of the user as they can be players,playground owners or administrators.
     * @return true when user is successfully created and added.
     */
    static public boolean createUser(String name,  String password, String email, String number, String location, UserType type)
    {

        if(UserManager.isValidUser(name))
            return false;

        User tmp;
        if(type == UserType.PlaygroundOwner)
            tmp = new PlaygroundOwner(name, password, email, number, location);
        else
            tmp = new Player(name, password, email, number, location);

        registeredUsers.add(tmp);
        return true;
    }

    /**
     * Gets login status.
     * @param name name of the user.
     * @param password password of the user
     * @return login status whether users data are valid or not.
     */
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

    /**
     *gets users by their indices.
     * @param index index of the user.
     * @return User.
     */
    static public User getUser(int index)
    {
        return registeredUsers.get(index);
    }

    static public boolean isValidUser(String name)
    {
        for(User user: registeredUsers) {
            if(name.equalsIgnoreCase(user.getName()))
            {
                return true;
            }
        }
        return false;
    }
}
