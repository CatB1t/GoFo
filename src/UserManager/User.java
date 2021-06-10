package UserManager;

public class User
{

    private String name ;
    private static int ID = 0;
    private String email;
    private String password ;
    private String phone ;
    private String location;
    private UserType type;

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

    public boolean verify (String name, String password)
    {
        return this.name.equalsIgnoreCase(name) && this.password.equals(password);
    }

    public UserType getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }
}
