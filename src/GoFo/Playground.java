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

    public ArrayList<Slot> getAvailableSchedule() { return availableSchedule; }

    public Playground()
    {
        this.name = "";
        this.size = 0;
        this.location = "";
        this.pricePerHour = 0;
    }

    public Playground(String name, String location, int size, long pricePerHour)
    {
        this.name = name;
        this.location = location;
        this.size = size;
        this.pricePerHour = pricePerHour;
    }

    public void createSlot(String start, String end, String day)
    {
        Slot slot = new Slot(start, end, day);
        availableSchedule.add(slot);
    }

    public String getName() { return name; }
    public void bookSlot(int index)
    {
        bookedSchedule.add(availableSchedule.get(index));
    }

}
