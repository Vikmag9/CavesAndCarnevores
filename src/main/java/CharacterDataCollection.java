import Items.Inventory;

import java.util.HashMap;

public interface CharacterDataCollection {
    public String getName();
    public String getRaceName();
    public String getJobName();
    public String getBackground();
    public Inventory getInventory();
    public HashMap<StatName, Integer> getStats();
    public int getLevel();
}