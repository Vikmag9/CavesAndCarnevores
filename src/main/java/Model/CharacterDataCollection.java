package Model;

import Model.Items.Inventory;

import java.util.HashMap;

/**
 * A public interface for the CharacterDataCollection.
 * This interface is implemented by the CharacterDataClass and the character class.
 * Ensures that a character has all the necessary data to be created.
 */
public interface CharacterDataCollection {
    public String getName();
    public String getRaceName();
    public String getJobName();
    public String getBackground();
    public Inventory getInventory();
    public String getAlignment();
    public HashMap<StatName, Integer> getStats();
    public int getLevel();
    public String getLanguages();
    public String getOrganisations();
    public String getEarlierLife();
}
