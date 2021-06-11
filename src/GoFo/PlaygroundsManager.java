package GoFo;

import java.util.ArrayList;

public class PlaygroundsManager
{
    static private ArrayList<Playground> playgrounds = new ArrayList<Playground>();

    /**
     * gets playgrounds.
     * @return playgrounds.
     */
    static public ArrayList<Playground> getPlaygrounds() { return playgrounds; }

    /**
     *Adds new playground.
     * @param playground The newly added playground.
     * @return true after adding the new playground.
     */
    static public boolean addPlayground(Playground playground)
    {
        playgrounds.add(playground);
        return true;
    }

    /**
     *Deletes a playground.
     * @param index index of the playground in the arraylist of playgrounds.
     * @return true when the playground is deleted.
     */
    static public boolean deletePlayground(int index)
    {
        playgrounds.remove(index);
        return true;
    }
}
