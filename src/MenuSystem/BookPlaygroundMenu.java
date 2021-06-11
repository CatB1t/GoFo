package MenuSystem;

import BookingProcess.BookingManager;
import GoFo.Playground;
import GoFo.PlaygroundsManager;
import GoFo.Slot;
import UserManager.Player;

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
     * make player choose a slot for the playground they want to book.
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
                + "Price per hour: " + playgroundToBook.getPricePerHour() + " EGP, Location: " + playgroundToBook.getLocation() + "Size: " + playgroundToBook.getSize()
                + "\nChoose a slot :\n";

        endIndex = cached.size();
        for(int i = 0; i < cached.size(); i++)
        {
            toPrint += (i + 1) + ". " + cached.get(i).toString();
        }

        System.out.println(toPrint);
    }

    /**
     *Handles player's choice
     * @return true
     */
    public boolean Handle()
    {
        if(shouldSkipInput)
            return true;

        int choice = MenuManager.getIntInput();

        if(choice < 0 || choice > endIndex + 1) // TODO loop for valid input
        {
            System.out.println("Invalid input");
            return true;
        }

        if(choice == endIndex + 1)
            return true;

        // TODO show confirmation to book
        System.out.println("Booked slot successfully");
        BookingManager.bookSlot(playerToBook, playgroundToBook , playgroundToBook.getAvailableSchedule().get(choice - 1));
        return true;
    }
}
