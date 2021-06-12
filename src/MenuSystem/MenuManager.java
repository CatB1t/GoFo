package MenuSystem;

import java.util.Scanner;
import java.util.Stack;

public class MenuManager
{

    static Scanner keyboard;
    static Stack<Menu> menusToExecute = new Stack<Menu>();

    /**
     * initializes the scanner for other menus to use
     */
    public MenuManager()
    {
        keyboard = new Scanner(System.in);
    }

    /**
     * Gets a valid string input, and prints the statement
     * @param toPrint statement to print before asking for input
     * @return A "Word" string input from the user
     */
    static public String getStringWordInput (String toPrint)
    {
        System.out.println(toPrint);
        return keyboard.next();
    }

    /**
     * Gets a valid string input
     * @return A "Word" string input from the user
     */
    static public String getStringWordInput()
    {
        return keyboard.next();
    }

    /**
     * Gets a valid string line input
     * @param toPrint statement to print before asking for input
     * @return A string line input from the user
     */
    static public String getStringLineInput(String toPrint)
    {
        System.out.println(toPrint);
        return keyboard.nextLine();
    }

    /**
     * Gets a valid string line input
     * @return A string line input from the user
     */
    static public String getStringLineInput()
    {
        clearBuffer();
        return keyboard.nextLine();
    }

    /**
     * Gets a valid integer input
     * @param toPrint statement to print before asking for input
     * @return An integer input from the user
     */
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

    /**
     * Gets a valid integer input, checks if it's in range provided.
     * @param min minimum valid choice to accept from the user
     * @param max maximum valid choice to accept from the user
     * @return An integer input from the user in range between min and max
     */
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

    /**
     * Gets a valid integer input
     * @return An integer input from the user
     */
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

    /**
     * Gets a valid double input
     * @return A double input from the user
     */
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

    /**
     * Clears the buffer of the scanner
     */
    static public void clearBuffer ()
    {
        keyboard.nextLine();
    }

    /**
     * Adds a new menu to the stack
     * @param menu Menu to add
     */
    static public void addMenu(Menu menu)
    {
        menusToExecute.push(menu);
    }

    /**
     * Removes a menu from the stack
     * @param menu Menu to remove
     */
    static public void ignoreMenu(Menu menu)
    {
        menusToExecute.remove(menu);
    }

    /**
     * Runs the menus that is in the stack, exists when user asks to exit
     */
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
