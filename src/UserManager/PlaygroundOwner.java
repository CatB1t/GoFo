package UserManager;

import GoFo.Playground;
import GoFo.PlaygroundsManager;
import MenuSystem.PlaygroundOwnerMenu;

import java.util.ArrayList;

public class PlaygroundOwner extends User
{

    private ArrayList<Playground> ownedPlaygrounds = new ArrayList<Playground>();

    public PlaygroundOwner(String name, String password, String email, String phone, String location, UserType type)
    {
        super(name, password, email, phone, location, type);
    }

    public ArrayList<Playground> getOwnedPlaygrounds()
    {
        return ownedPlaygrounds;
    }

    public boolean createPlayground(String name, String location, int size, long perPriceHour)
    {
        // TODO pass owner as a reference
        Playground playground = new Playground(name, location, size, perPriceHour);
        PlaygroundsManager.addPlayground(playground);
        return true;
    }

}
