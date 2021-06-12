package MenuSystem;

import GoFo.Playground;
import GoFo.Slot;

import java.util.ArrayList;

public class PlaygroundManageMenu implements Menu
{
    Playground playground;

    /**
     * Parametrized constructor sets playground.
     * @param playground Playground to operate on
     */
    public PlaygroundManageMenu(Playground playground)
    {
        this.playground = playground;
    }

    /**
     * Show playground menu so the playground owner can choose between adding or removing a slot,showing available slots or return to previous page.
     */
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

    /**
     * Handles playground owner's choice.
     * @return false when owner choose to add , remove or enters invalid option,and return true if they decided to show avilable slots.
     */
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

    /**
     * Adds a slot.
     */
    private void addSlot()
    {
        String date = MenuManager.getStringWordInput("Enter date of the slot (day/month/year): ");
        String start = MenuManager.getStringWordInput("Enter start time of the slot (00:00) to (24:00): ");
        String end = MenuManager.getStringWordInput("Enter end time of the slot (00:00) to (24:00): ");
        playground.createSlot(start, end, date);
    }

    /**
     * Removes a slot.
     */
    private void removeSlot()
    {
        ArrayList<Slot> cachedSlots = playground.getAvailableSchedule();

        if(cachedSlots.isEmpty())
        {
            System.out.println("No available slots to remove.");
            return;
        }

        String toPrint = "Choose a slot to remove:\n";

        for(int i = 0; i < cachedSlots.size(); i++)
        {
            toPrint += (i + 1) + ". " + cachedSlots.get(i).toString() + "\n";
        }

        toPrint += (cachedSlots.size() + 1) + ". Return.";

        System.out.println(toPrint);

        int choice = MenuManager.getInputChoice(1, cachedSlots.size() + 1);

        if(choice == (cachedSlots.size() + 1) )
            return;

        playground.removeSlot(choice - 1);
        System.out.println("Slot removed");
    }

    /**
     * Shows all available slots.
     */
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
