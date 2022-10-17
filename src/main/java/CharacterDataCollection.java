import Items.Inventory;
import org.w3c.dom.CharacterData;

import java.util.HashMap;

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
