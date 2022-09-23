package Items;

public class Consumable extends InventoryItem{

    public Consumable(String itemType, String itemName, String itemDescription, int itemAmount, int itemValue, Double itemWeight, boolean isMagical) {
        super(itemType, itemName, itemDescription, itemAmount, itemValue, itemWeight, isMagical);
    }
}
