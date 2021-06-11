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

    private int endIndex = 0;

    public BookPlaygroundMenu(int index, Player player)
    {
        playgroundToBook = PlaygroundsManager.getPlayground(index);
    }

    public void Show()
    {
        String toPrint = "====== Booking for " + playgroundToBook.getName() + "======\n"
                + "Choose a slot :\n";

        ArrayList<Slot> cached = playgroundToBook.getAvailableSchedule();
        endIndex = cached.size();
        for(int i = 0; i < cached.size(); i++)
        {
            toPrint += (i + 1) + ". " + cached.get(i).toString();
        }

        System.out.println(toPrint);
    }

    public boolean Handle()
    {
        int choice = MenuManager.getIntInput();

        if(choice < 0 || choice > endIndex) // TODO loop for valid input
        {
            System.out.println("Invalid input");
            return true;
        }

        if(choice == endIndex)
            return true;

        // TODO show confirmation to book
        BookingManager.bookSlot(playerToBook, playgroundToBook , playgroundToBook.getAvailableSchedule().get(choice - 1));
        return true;
    }
}
