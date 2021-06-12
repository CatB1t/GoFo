package UserSystem;

public class User
{

    private String name ;
    private static int ID = 0;
    private String email;
    private String password ;
    private String phone ;
    private String location;
    private UserType type;

    /**
     *parametrized constructor sets user's information and sets them a unique ID.
     * @param name name of the user.
     * @param password password that user creates for his profile.
     * @param email email of the user.
     * @param phone user's phone number.
     * @param location user's location.
     * @param type user's type and it can be player, playground owner or Administrator
     */
    public User (String name, String password, String email, String phone, String location, UserType type)
    {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.type = type;
        ID++;
    }

    /**
     *verifies user's name and password.
     * @param name User's name.
     * @param password User's password.
     * @return boolean detects the whether name and password are verified or not.
     */
    public boolean verify (String name, String password)
    {
        return this.name.equalsIgnoreCase(name) && this.password.equals(password);
    }

    /**
     *get user's type.
     * @return user's type whether it is player,playground owner or Administrator.
     */
    public UserType getType()
    {
        return type;
    }

    /**
     *gets user's name.
     * @return name of the user.
     */
    public String getName()
    {
        return name;
    }
}
