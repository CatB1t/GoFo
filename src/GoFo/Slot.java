package GoFo;

public class Slot
{
    public String startTime;
    public String endTime;
    public String day;

    /**
     *parametrized constructor sets slot's information.
     * @param start starting time of the slot.
     * @param end ending time of the slot.
     * @param day day of the slot.
     */
    public Slot(String start, String end, String day)
    {
        this.startTime = start;
        this.endTime = end;
        this.day = day;
    }

    /**
     * prints slot info.
     * @return string contains slot information : starting , ending time and the slot's day.
     */
    @Override
    public String toString()
    {
        return String.format(startTime + " Till " + endTime +" On " + day);
    }
}
