import Model.Items.Inventory;
import Model.Items.InventoryItem;
import Model.Items.InventoryItemBuilder;
import Model.Items.InventoryItemDirector;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Objects;

import static org.junit.Assert.assertFalse;
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
    public void testInventoryItem(){
        InventoryItemBuilder builder = new InventoryItemBuilder("Sword", "Short sword", "Goes clink clonk", 2, 3.7, false);
        builder.atkBonus(4);
        builder.isequipped(false);
        InventoryItem item = new InventoryItem(builder);

        InventoryItemDirector director = new InventoryItemDirector();
        InventoryItem item2 = director.createEquippable("Sword", "Short sword", "Goes clink clonk", 2, 3.7, false, 0, 4);

        assertTrue(item.getAtkBonus() == item2.getAtkBonus());
        assertTrue(item.getItemType().equals(item2.getItemType()));
        assertTrue(item.getItemDescription().equals(item2.getItemDescription()));
        assertTrue(Objects.equals(item.getItemWeight(), item2.getItemWeight()));

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

    @Test
    public void testCreateConsumableItem(){
        InventoryItemDirector director = new InventoryItemDirector();
        InventoryItem item = director.createConsumableItem("Potion", "Health Potion", "Heals 2d4", 5, 0.5, false);
        assertTrue(item.getItemName().equals("Health Potion"));
    }

    @Test
    public void testCreateEquippableItem(){
        InventoryItemDirector director = new InventoryItemDirector();
        InventoryItem item = director.createEquippable("Sword", "Short Sword", "Goes clink clonk", 2, 3.7, false, 0, 4);
        assertTrue(item.getItemName().equals("Short Sword"));
    }

    @Test
    public void testCreateMiscItem(){
        InventoryItemDirector director = new InventoryItemDirector();
        InventoryItem item = director.createMisc("Misc", "Torch", "Gives light", 1, 0.5, false, 0, 0);
        assertTrue(item.getItemName().equals("Torch"));
    }

    @Test
    public void testGetCoinBag(){
        Inventory inventory = new Inventory(10);
        inventory.getCoinBag().addCoin(10);
        assertTrue(inventory.getCoinAmount() == 20.0);
    }

    @Test
    public void testSetCoin(){
        Inventory inventory = new Inventory(10);
        inventory.getCoinBag().setCoins(100);
        assertTrue(inventory.getCoinAmount() == 100.0);
    }

    @Test
    public void testGetCoin(){
        Inventory inventory = new Inventory(10);
        int coins =inventory.getCoinBag().getCoin();
        assertTrue(inventory.getCoinAmount() == coins);
    }

    @Test
    public void testTakeCoins(){
        Inventory inventory = new Inventory(10);
        inventory.getCoinBag().addCoin(10);
        inventory.getCoinBag().takeCoins(5);
        assertTrue(inventory.getCoinAmount() == 15.0);
    }

    @Test
    public void testGetHasAc(){
        InventoryItemDirector director = new InventoryItemDirector();
        InventoryItem item = director.createEquippable("Armour", "Leather armour", "Sort off protects", 2, 3.7, false, 0, 4);
        boolean hasAC = item.getHasAc();
        assertTrue(hasAC == true);
    }

    @Test
    public void testIsMagical(){
        InventoryItemDirector director = new InventoryItemDirector();
        InventoryItem item = director.createEquippable("Armour", "Leather armour", "Sort off protects", 2, 3.7, false, 0, 4);
        boolean isMagical = item.getIsMagical();
        assertFalse(isMagical);
    }
}
