public class InventoryItem { // Functions as a data class, Each inventory item is to be constructed by this class
    public String itemType;

    public String itemName;

    public String itemDescription;
    public int itemAmount;

    public int itemValue;

    public InventoryItem(String itemType, String itemName, String itemDescription, int itemAmount, int itemValue){
        this.itemType = itemType;
        this.itemAmount = itemAmount;
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemDescription = itemDescription;

    }

    public String getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getItemAmount() {
        return itemAmount;
    }

     public int getItemValue() {
         return itemValue;
     }
}
