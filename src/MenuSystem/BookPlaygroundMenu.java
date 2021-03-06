package MenuSystem;

import BookingSystem.BookingManager;
import PlaygroundSystem.Playground;
import PlaygroundSystem.PlaygroundsManager;
import BookingSystem.Slot;
import UserSystem.Player;

import java.util.ArrayList;

public class BookPlaygroundMenu implements Menu
{
    private Playground playgroundToBook;
    private Player playerToBook;
    private boolean shouldSkipInput = false;

    private int endIndex = 0;

    /**
     * parametrized constructor set values to the playground the player want to book.
     * @param index index of the playground the player want to book.
     * @param player the player who wants to book the playground.
     */
    public BookPlaygroundMenu(int index, Player player)
    {
        playgroundToBook = PlaygroundsManager.getPlayground(index);
        playerToBook = player;
    }

    /**
     * Make player choose a slot for the playground they want to book.
     */
    public void Show()
    {
        ArrayList<Slot> cached = playgroundToBook.getAvailableSchedule();

        if(cached.isEmpty())
        {
            System.out.println("\nNo schedule available for this playground");
            shouldSkipInput = true;
            return;
        }

        String toPrint = "\n====== Booking for " + playgroundToBook.getName() + " ======\n"
                + "Price per hour: " + playgroundToBook.getPricePerHour() + " EGP, Location: " + playgroundToBook.getLocation() + ". Size: " + playgroundToBook.getSize()
                + "\nChoose a slot :\n";

        endIndex = cached.size();
        for(int i = 0; i < cached.size(); i++)
        {
            toPrint += (i + 1) + ". " + cached.get(i).toString();
        }

        System.out.println(toPrint);
    }

    /**
     * Handles player's choice
     * @return true to exit
     */
    public boolean Handle()
    {
        if(shouldSkipInput)
            return true;

        int choice = MenuManager.getInputChoice(1, endIndex + 1);

        if(choice == endIndex + 1)
            return true;

        while(true)
        {
            String stringInput = MenuManager.getStringWordInput("Are you sure you want to book this slot? (y/n): ");
            if(stringInput.equalsIgnoreCase("y") || stringInput.equalsIgnoreCase("yes"))
                break;
            if (stringInput.equalsIgnoreCase("n") || stringInput.equalsIgnoreCase("no"))
                return true;
        }

        System.out.println("Booked slot successfully");
        BookingManager.bookSlot(playerToBook, playgroundToBook , playgroundToBook.getAvailableSchedule().get(choice - 1));
        return true;
    }
}
