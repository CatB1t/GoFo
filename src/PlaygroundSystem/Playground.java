package PlaygroundSystem;

import BookingSystem.Slot;

import java.util.ArrayList;

public class Playground
{
    private String name;
    private int size;
    private String location;
    private Double pricePerHour;
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
        this.pricePerHour = 0d;
    }

    /**
     * parametrized constructor that sets playground's data.
     * @param name name of the playground
     * @param location location of the playground.
     * @param size size of the playground.
     * @param pricePerHour playground's price per hour.
     */
    public Playground(String name, String location, int size, Double pricePerHour)
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

    /**
     * Removes a slot.
     * @param index index of the slot that will be deleted.
     */
    public void removeSlot(int index)
    {
        availableSchedule.remove(index);
    }

    /**
     * Gets playground name.
     * @return name of the playground.
     */
    public String getName() { return name; }
    /**
     * Books a slot and adds it to the booked schedule.
     * @param slot the slot that will be booked.
     */
    public void bookSlot(Slot slot)
    {
        bookedSchedule.add(slot);
        availableSchedule.remove(slot);
    }

    /**
     * Gets slot's price per hour.
     * @return price of the slot per hour.
     */
    public Double getPricePerHour () {
        return pricePerHour;
    }

    /**
     * Gets location of the playground.
     * @return playground's location.
     */
    public String getLocation ()
    {
        return location;
    }

    /**
     * Gets size of the playground.
     * @return playground's size.
     */

    public int getSize()
    {
        return size;
    }

    /**
     * Displays Statement with all playground's data.
     * @return string contains playground's data such as:name,price per hour,location and size.
     */

    @Override
    public String toString()
    {
        return "Playground: " + name + ". Price per hour: " + pricePerHour + ". Location: " + location + ". Size: " + size + ".";
    }
}
