package UserManager;

import GoFo.Playground;
import GoFo.PlaygroundsManager;
import MenuSystem.PlaygroundOwnerMenu;

import java.util.ArrayList;

public class PlaygroundOwner extends User
{

    private ArrayList<Playground> ownedPlaygrounds = new ArrayList<Playground>();

    /**
     * parametrized constructor sets data of the playground owner.
     * @param name name of the playground owner.
     * @param password password creted by the playground owner.
     * @param email email of the playground owner.
     * @param phone phone number of the playground owner.
     * @param location location of the playground owner.
     */
    public PlaygroundOwner(String name, String password, String email, String phone, String location)
    {
        super(name, password, email, phone, location, UserType.PlaygroundOwner);
    }

    /**
     *Gets all playgrounds owned by the playground owner.
     * @return all owned playgrounds.
     */
    public ArrayList<Playground> getOwnedPlaygrounds()
    {
        return ownedPlaygrounds;
    }

    /**
     *creates a new playground for playground owner using the playground's data.
     * @param name name of the playground.
     * @param location location of the playground.
     * @param size size of the playground.
     * @param perPriceHour playground's price per hour
     * @return true after creating the new playground.
     */
    public boolean createPlayground(String name, String location, int size, long perPriceHour)
    {
        // TODO pass owner as a reference
        Playground playground = new Playground(name, location, size, perPriceHour);
        ownedPlaygrounds.add(playground);
        PlaygroundsManager.addPlayground(playground);
        return true;
    }

}
