import Items.InventoryItem;
import Items.InventoryItemBuilder;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void createInventory(){
        InventoryItemBuilder builder = new InventoryItemBuilder("Sword", "Short sword", "Goes clink clonk", 2, 3.7, false);
        InventoryItem item = new InventoryItem(builder);
    }
}
