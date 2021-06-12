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

    static public String getStringWordInput (String toPrint)
    {
        System.out.println(toPrint);
        return keyboard.next();
    }

    static public String getStringWordInput()
    {
        return keyboard.next();
    }

    static public String getStringLineInput(String toPrint)
    {
        System.out.println(toPrint);
        clearBuffer();
        return keyboard.nextLine();
    }

    static public String getStringLineInput()
    {
        clearBuffer();
        return keyboard.nextLine();
    }

    static public int getIntInput(String toPrint)
    {
        int toReturn = 0;
        while(true)
        {
            System.out.print(toPrint);
            if(keyboard.hasNextInt()) {
                toReturn = keyboard.nextInt();
                clearBuffer();
                break;
            }
            clearBuffer();
            System.out.print("Not a valid choice. Try again: ");
        }
        return toReturn;
    }

    static public int getInputChoice(int min, int max)
    {
        int toReturn = 0;
        while(true)
        {
            System.out.print("Enter your choice: ");
            if(keyboard.hasNextInt()) {
                toReturn = keyboard.nextInt();
                if(toReturn <= max && toReturn >= min)
                {
                    clearBuffer();
                    break;
                }
            }
            clearBuffer();
            System.out.print("Not a valid choice. Try again: ");
        }
        return toReturn;
    }

    static public int getIntInput()
    {
        int toReturn = 0;
        while(true)
        {
            System.out.print("Enter your choice: ");
            if(keyboard.hasNextInt()) {
                toReturn = keyboard.nextInt();
                clearBuffer();
                break;
                }
            clearBuffer();
            System.out.print("Not a valid choice. Try again: ");
        }
        return toReturn;
    }

    static public Double getDoubleInput(String toPrint)
    {
        Double toReturn = 0d;
        while(true)
        {
            System.out.print(toPrint);
            if(keyboard.hasNextDouble()) {
                toReturn = keyboard.nextDouble();
                clearBuffer();
                break;
            }
            clearBuffer();
            System.out.print("Not a valid choice. Try again: ");
        }
        return toReturn;
    }

    static private void clearBuffer ()
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
