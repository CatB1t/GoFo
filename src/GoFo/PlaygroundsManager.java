package GoFo;

import java.util.ArrayList;

public class PlaygroundsManager
{
    static private ArrayList<Playground> playgrounds;

    static public ArrayList<Playground> getPlaygrounds() { return playgrounds; }

    static public boolean addPlayground(Playground playground)
    {
        playgrounds.add(playground);
        return true;
    }

    static public boolean deletePlayground(int index)
    {
        playgrounds.remove(index);
        return true;
    }
}
