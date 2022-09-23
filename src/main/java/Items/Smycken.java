package Items;

public class Smycken extends InventoryItem implements Equippable{
    boolean equipped;

    public Smycken(String itemType, String itemName, String itemDescription, int itemAmount, int itemValue, Double itemWeight, boolean isMagical, String effect) {
        super(itemType, itemName, itemDescription, itemAmount, itemValue, itemWeight, isMagical, effect);
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
