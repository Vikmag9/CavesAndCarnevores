package Items;

public class InventoryItemBuilder {
    private String itemType;
    private String itemName;
    private String itemDescription;
    private int itemAmount;
    private int itemValue;
    private double itemWeight;
    private int ac;
    private int atkBonus;
    private boolean isMagical;
    private boolean isequipped;

    public InventoryItemBuilder(String itemType, String itemName, String itemDescription, int itemValue, Double itemWeight, boolean isMagical) {
        //Compulsory attributes
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
        this.isMagical = isMagical;
    }
        //Optional attributes

    public InventoryItemBuilder ac(int ac){
        this.ac = ac;
        return this;
    }

    public InventoryItemBuilder atkBonus(int atkBonus){
        this.atkBonus = atkBonus;
        return this;
    }

    public InventoryItemBuilder equipped(boolean isequipped){
        this.isequipped = isequipped;
        return this;
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
