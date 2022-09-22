package Items;

public class Clothing extends InventoryItem implements Equippable {
    private boolean equipped;

    private int armorClass;
    Clothing(int armorClass, String itemType, String itemName, String itemDescription, int itemAmount, int itemValue, Double itemWeight, boolean isMagical) {
        super(itemType, itemName, itemDescription, itemAmount, itemValue, itemWeight, isMagical);
        this.equipped = false;
        this.armorClass = armorClass;
    }

    public void equip(){
        this.equipped = true;
    }

    public void unequip(){
        this.equipped = false;
    }

    public int getArmorClass(){
        return this.armorClass;
    }

    public boolean isEquipped(){
        return this.equipped;
    }

}
