package Items;

public class Wearable {
    private boolean equipped;
    Wearable(){
        this.equipped = false;
    }

    public void equip(){
        this.equipped = true;
    }

    public void unequip(){
        this.equipped = false;
    }

}
