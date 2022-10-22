package Model.Items;

public class InventoryItemBuilder {
    private String itemType; //TODO Make into ENUM
    private String itemName;
    private String itemDescription;
    private int itemAmount;
    private int itemValue;
    private double itemWeight;
    int ac;
    private boolean hasAc = false;
    int atkBonus;
    private boolean isMagical;
    boolean isequipped;
    boolean isequippable;
    boolean isconsumable;

    public InventoryItemBuilder(String itemType, String itemName, String itemDescription, int itemValue, Double itemWeight, boolean isMagical) {
        //Compulsory attributes
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
        this.isMagical = isMagical;
        this.isconsumable = false;
        this.isequippable = false;
    }
        //Optional attributes

    public InventoryItemBuilder ac(int ac){
        this.hasAc = true;
        this.ac = ac;
        return this;
    }

    public InventoryItemBuilder atkBonus(int atkBonus){
        this.atkBonus = atkBonus;
        return this;
    }

    public InventoryItemBuilder isequipped(boolean isequipped){
        this.isequipped = isequipped;
        return this;
    }
    public void setconsumability(boolean consumable) {
        this.isconsumable = consumable;
    }

    public void setequippablility(boolean consumable) {
        this.isconsumable = consumable;
    }

    public boolean gethasAc(){
        return this.hasAc;
    }

    public boolean getIsEquipped(){
        return this.isequipped;
    }

    public String getItemType(){
        return this.itemType;
    }


    public String getItemName() {
        return this.itemName;
    }

    public int getItemValue() {
        return this.itemValue;
    }


    public String getItemDescription() {
        return this.itemDescription;
    }

    public double getItemWeight() {
        return this.itemWeight;
    }

    public boolean getIsMagical() {
        return this.isMagical;
    }

}
