package com.company.MenuSystem;

import com.company.UserManager.User;

public class RegisterMenu implements Menu
{
    private User createdUser;

    public void Show ()
    {
        String toPrint = "========= Register =========\n " +
                "Choose the role: " +
                "1. Playground Owner\n" +
                "2. Playground\n" +
                "3. Return\n";
        System.out.println(toPrint);
    }

    public boolean Handle ()
    {
        switch(MenuManager.getIntInput())
        {
            case 1: // Playground Owner
                createdUser = createUser(User.UserType.PlaygroundOwner);
                return false;
            case 2: // Playground
                createdUser = createUser(User.UserType.Player);
                return false;
            case 3: // Exit
                return true;
        }
        return false;
    }

    private User createUser (User.UserType type)
    {
        String name, password, email, location, phone;

        System.out.println("Enter your username: ");
        name = MenuManager.keyboard.nextLine();

        System.out.println("Enter your password: ");
        password = MenuManager.keyboard.nextLine();

        System.out.println("Enter your email: ");
        email = MenuManager.keyboard.nextLine();

        System.out.println("Enter your phone: ");
        phone = MenuManager.keyboard.nextLine();

        System.out.println("Enter your location: ");
        location = MenuManager.keyboard.nextLine();

        return new User(name, password, email, phone, location, type);
    }
}
