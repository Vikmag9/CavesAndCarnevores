package Items;

public class Weapon extends InventoryItem implements Equippable{
    boolean equipped;
    String damage;
    public Weapon(String itemType, String itemName, String itemDescription, int itemAmount, int itemValue, Double itemWeight, boolean isMagical, String damage) {
        super(itemType, itemName, itemDescription, itemAmount, itemValue, itemWeight, isMagical);

        this.equipped = false;
        this.damage = damage;
    }

    @Override
    public void equip() {
        this.equipped = true;
    }

    @Override
    public void unequip() {
        this.equipped = false;
    }

    public String getDamage(){
        return this.damage;
    }
}
