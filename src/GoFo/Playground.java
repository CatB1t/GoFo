package GoFo;

import java.util.ArrayList;

public class Playground
{
    private String name;
    private int size;
    private String location;
    private long pricePerHour;
    private ArrayList<Slot> availableSchedule = new ArrayList<Slot>();
    private ArrayList<Slot> bookedSchedule = new ArrayList<Slot>();

    /**
     * gets available slots in the schedule.
     * @return an array list of available slots.
     */
    public ArrayList<Slot> getAvailableSchedule() { return availableSchedule; }

    /**
     * default constructor sets initial values for playground data.
     */
    public Playground()
    {
        this.name = "";
        this.size = 0;
        this.location = "";
        this.pricePerHour = 0;
    }

    /**
     * parametrized constructor that sets playground's data.
     * @param name name of the playground
     * @param location location of the playground.
     * @param size size of the playground.
     * @param pricePerHour playground's price per hour.
     */
    public Playground(String name, String location, int size, long pricePerHour)
    {
        this.name = name;
        this.location = location;
        this.size = size;
        this.pricePerHour = pricePerHour;
    }

    /**
     * Creates a new a slot and adds it to the schedule.
     * @param start starting time of the slot.
     * @param end ending time of the slot.
     * @param day day of the slot.
     */
    public void createSlot(String start, String end, String day)
    {
        Slot slot = new Slot(start, end, day);
        availableSchedule.add(slot);
    }

    public String getName() { return name; }
    /**
     * Books a slot and adds it to the booked schedule.
     * @param index index of the slot that will be booked.
     */
    public void bookSlot(int index)
    {
        bookedSchedule.add(availableSchedule.get(index));
    }

}
