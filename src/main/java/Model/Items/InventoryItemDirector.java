package Model.Items;

public class InventoryItemDirector {

    public InventoryItem createConsumableItem(String itemType, String itemName, String itemDescription, int itemValue, Double itemWeight, boolean isMagical){
        InventoryItemBuilder consumableBuilder = new InventoryItemBuilder(itemType, itemName, itemDescription, itemValue, itemWeight, isMagical);
        consumableBuilder.setconsumability(true);
        return new InventoryItem(consumableBuilder);
    }

    public InventoryItem createEquippable(String itemType, String itemName, String itemDescription, int itemValue, Double itemWeight, boolean isMagical, int ac, int atkBonus){
        InventoryItemBuilder equippableBuilder = new InventoryItemBuilder(itemType, itemName, itemDescription, itemValue, itemWeight, isMagical);
        equippableBuilder.setequippablility(true);
        equippableBuilder.ac(ac);
        equippableBuilder.atkBonus(atkBonus);
        return new InventoryItem(equippableBuilder);
    }

    public InventoryItem createMisc(String itemType, String itemName, String itemDescription, int itemValue, Double itemWeight, boolean isMagical, int ac, int atkBonus){
        InventoryItemBuilder miscBuilder = new InventoryItemBuilder(itemType, itemName, itemDescription, itemValue, itemWeight, isMagical);
        miscBuilder.ac(ac);
        miscBuilder.atkBonus(atkBonus);
        return new InventoryItem(miscBuilder);
    }

}

