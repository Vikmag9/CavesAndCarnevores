package Items;

public class Jewellery extends InventoryItem implements Equippable{
    boolean equipped;

    public Jewellery(String itemType, String itemName, String itemDescription, int itemAmount, int itemValue, Double itemWeight, boolean isMagical) {
        super(itemType, itemName, itemDescription, itemAmount, itemValue, itemWeight, isMagical);
        this.equipped = false;
    }

    @Override
    public void equip() {
        this.equipped = true;
    }

    @Override
    public void unequip() {
        this.equipped = false;
    }
}
