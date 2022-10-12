package Items;

public class InventoryItem { // Functions as a data class, Each inventory item is to be constructed by this class
    private String itemType;

    private String itemName;

    private String itemDescription;
    private int itemAmount;

    private int itemValue;

    private double itemWeight;

    private boolean isMagical;

    private int ac;

    private int atkBonus;

    private boolean isequipped;


    public InventoryItem(InventoryItemBuilder builder) {
        this.itemType = builder.getItemType();
        this.itemName = builder.getItemName();
        this.itemValue = builder.getItemValue();
        this.itemDescription = builder.getItemDescription();
        this.itemWeight = builder.getItemWeight();
        this.isMagical = builder.getIsMagical();
        this.ac = builder.ac;
        this.atkBonus = builder.atkBonus;
        this.isequipped = builder.isequipped;
    }

    public String getItemType() {
        return this.itemType;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public int getItemAmount() {
        return this.itemAmount;
    }

    public int getItemValue() {
         return itemValue;
     }

    public Double getItemWeight() {
        return itemWeight;
     }

    public int getac(){
        return this.ac;
    }

    public int getAtkBonus(){
        return this.atkBonus;
    }





}
