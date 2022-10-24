package Model;

import Model.Items.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This interface is used when creating a new character.
 * Ensures that all the necessary data is present.
 * Also is implemented by the Model.CharacterDataClass.
 */
public interface CharacterDataCollection {
    public String getName();
    public String getRaceName();
    public String getJobName();
    public String getBackground();
    public Inventory getInventory();
    public String getAlignment();
    public int getXp();
    public HashMap<StatName, Integer> getStats();
    public int getLevel();
    public String getLanguages();
    public String getOrganisations();
    public String getEarlierLife();
    public String getNotes();
    public ArrayList<ProficiencySkills> getProficiencySkills();

}
