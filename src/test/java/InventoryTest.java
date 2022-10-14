import Items.Inventory;
import Items.InventoryItem;
import Items.InventoryItemBuilder;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static java.util.Objects.isNull;
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
        //assertTrue(isNull(item.getac()));
        System.out.println(item.getAc());
    }

    @Test
    public void createInventory(){
        InventoryItemBuilder builder = new InventoryItemBuilder("Sword", "Short sword", "Goes clink clonk", 2, 3.7, false);
        builder.atkBonus(4);
        builder.isequipped(false);
        InventoryItem item = new InventoryItem(builder);
        map = new HashMap<String, InventoryItem>();
        map.put(item.getItemName(), item);


    }
}
