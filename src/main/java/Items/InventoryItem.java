package Items;

public class InventoryItem { // Functions as a data class, Each inventory item is to be constructed by this class
    public String itemType;

    public String itemName;

    public String itemDescription;
    public int itemAmount;

    public int itemValue;

    public double itemWeight;

    public InventoryItem(String itemType, String itemName, String itemDescription, int itemAmount, int itemValue, Double itemWeight) {
        this.itemType = itemType;
        this.itemAmount = itemAmount;
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;

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
