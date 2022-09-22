package Items;

public class Clothing implements Equippable {
    private boolean equipped;
    Clothing(){
        this.equipped = false;
    }

    public void equip(){
        this.equipped = true;
    }

    public void unequip(){
        this.equipped = false;
    }

}
