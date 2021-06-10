package MenuSystem;

import java.util.Scanner;
import java.util.Stack;

public class MenuManager
{

    static Scanner keyboard;
    static Stack<Menu> menusToExecute = new Stack<Menu>();

    public MenuManager()
    {

        keyboard = new Scanner(System.in);
    }

    static public int getIntInput()
    {
        // TODO input validation
        return keyboard.nextInt();
    }

    static public void clearBuffer ()
    {
        keyboard.nextLine(); // Clear the buffer.
    }

    static public void addMenuToStack(Menu menu)
    {
        menusToExecute.push(menu);
    }

    static public void ignoreMenuInStack(Menu menu)
    {
        menusToExecute.remove(menu);
    }

    static public void run ()
    {
        while(!menusToExecute.isEmpty())
        {
            Menu menuToRun = menusToExecute.peek();
            menuToRun.Show();
            if(menuToRun.Handle())
            {
                menusToExecute.pop();
            }
        }
    }


}
