import Model.Items.Inventory;
import Model.Items.InventoryItem;
import Model.Items.InventoryItemBuilder;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class InventoryTest {
    HashMap<String, InventoryItem> map;
    @Test
    public void createInventoryItem(){
        InventoryItemBuilder builder = new InventoryItemBuilder("Sword", "Short sword", "Goes clink clonk", 2, 3.7, false);
        builder.atkBonus(4);
        builder.isequipped(false);
        InventoryItem item = new InventoryItem(builder);

        assertTrue(item.getAtkBonus() == 4);

    }

    @Test
    public void createInventory(){
        InventoryItemBuilder builder = new InventoryItemBuilder("Sword", "Short sword", "Goes clink clonk", 2, 3.7, false);
        builder.atkBonus(4);
        builder.setequippablility(true);
        InventoryItem item = new InventoryItem(builder);
        Inventory inventory = new Inventory(10);
        inventory.addItem(item);

        InventoryItem item1 = inventory.getItem(0);
        assertTrue(item1.getItemValue() == 2);
    }
    @Test
    public void sellItem(){
        Inventory inventory = new Inventory(10);
        InventoryItemBuilder builder = new InventoryItemBuilder("Sword", "Short sword", "Goes clink clonk", 2, 3.7, false);
        builder.atkBonus(4);
        builder.setequippablility(true);
        InventoryItem item = new InventoryItem(builder);
        inventory.addItem(item);

        inventory.sellItem(0);

        assertTrue(inventory.getInventory().isEmpty());
        assertTrue(inventory.getCoinAmount() == 12);


    }
}
