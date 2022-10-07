package Items;

public class InventoryItem { // Functions as a data class, Each inventory item is to be constructed by this class
    private String itemType;

    private String itemName;

    private String itemDescription;
    private int itemAmount;

    private int itemValue;

    private double itemWeight;

    private boolean isMagical;

    private String effect;

    public InventoryItem(String itemType, String itemName, String itemDescription, int itemValue, Double itemWeight, boolean isMagical) {
        this.itemType = itemType;
        this.itemAmount = itemAmount;
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
        this.isMagical = isMagical;

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



}
