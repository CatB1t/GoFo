package MenuSystem;

import GoFo.Playground;
import GoFo.Slot;

import java.util.ArrayList;

public class PlaygroundManageMenu implements Menu
{
    Playground playground;

    public PlaygroundManageMenu(Playground playground)
    {
        this.playground = playground;
    }

    public void Show()
    {
        String toPrint = "====== " + playground.getName() + " ======\n"
                + "1. Add slot\n"
                + "2. Remove slot\n"
                + "3. Show available slots\n"
                + "4. Show info\n"
                + "5. Return\n";

        System.out.println(toPrint);
    }

    public boolean Handle()
    {
        switch(MenuManager.getIntInput())
        {
            case 1:
                // Add slot
                addSlot();
                return false;
            case 2:
                // Remove slots
                removeSlot();
                return false;
            case 3:
                showAvailableSlots();
                return false;
            case 4:
                System.out.println(playground.toString());
                return false;
            case 5: // Return
                return true;
            default:
                System.out.println("Invalid choice");
                return false;
        }
    }

    private void addSlot()
    {
        String date = MenuManager.getStringWordInput("Enter date of the slot (day/month/year): ");
        String start = MenuManager.getStringWordInput("Enter start time of the slot (00:00) to (24:00): ");
        String end = MenuManager.getStringWordInput("Enter end time of the slot (00:00) to (24:00): ");
        playground.createSlot(start, end, date);
    }

    private void removeSlot()
    {
        ArrayList<Slot> cachedSlots = playground.getAvailableSchedule();

        if(cachedSlots.isEmpty())
        {
            System.out.println("No available slots to remove.");
        }

        String toPrint = "Choose a slot to remove:\n";

        for(int i = 0; i < cachedSlots.size(); i++)
        {
            toPrint += (i + 1) + cachedSlots.get(i).toString() + "\n";
        }

        toPrint += cachedSlots.size() + ". Return.";

        System.out.println(toPrint);

        int choice = MenuManager.getInputChoice(1, cachedSlots.size() + 1);

        if(choice == cachedSlots.size())
            return;

        playground.removeSlot(choice - 1);
        System.out.println("Slot removed");
        return;
    }

    private void showAvailableSlots()
    {
        ArrayList<Slot> slots = playground.getAvailableSchedule();

        if(slots.isEmpty())
        {
            System.out.println("No slots available.");
        }

        String toPrint = "";

        for(int i = 0; i < slots.size(); i++)
        {
            toPrint += (i + 1) + ". " + slots.get(i).toString() +"\n";
        }

        System.out.println(toPrint);
    }
}
