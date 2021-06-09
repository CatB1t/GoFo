package MenuSystem;

import java.util.Scanner;

public class MenuManager
{
    static Scanner keyboard;

    public MenuManager()
    {

        keyboard = new Scanner(System.in);
    }

    static public int getIntInput()
    {
        return keyboard.nextInt();
    }


    static public void Execute(Menu menu)
    {
        while(true)
        {
            menu.Show();
            if(menu.Handle())
                break;
        }
    }

}
