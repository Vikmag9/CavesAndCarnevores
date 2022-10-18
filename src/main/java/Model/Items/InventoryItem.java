package Model.Items;

public class InventoryItem { // Functions as a data class, Each inventory item is to be constructed by this class
    private String itemType;

    private String itemName;

    private String itemDescription;
    private int itemAmount;

    private int itemValue;

    private double itemWeight;

    private boolean isMagical;
    private boolean hasAc;

    private int ac;

    private int atkBonus;

    private boolean isequipped;

    private int serialNumber;


    public InventoryItem(InventoryItemBuilder builder) {
        this.itemType = builder.getItemType();
        this.itemName = builder.getItemName();
        this.itemValue = builder.getItemValue();
        this.itemDescription = builder.getItemDescription();
        this.itemWeight = builder.getItemWeight();
        this.isMagical = builder.getIsMagical();
        this.serialNumber = 0;
        //Optional
        this.ac = builder.ac;
        this.hasAc = builder.gethasAc();
        this.atkBonus = builder.atkBonus;
        this.isequipped = builder.isequipped;
    }

    public String getItemType() {
        return this.itemType;
    }

    void setSerialNumber(int serialNumber){
        this.serialNumber = serialNumber;
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

    public int getAc(){
        return this.ac;
    }

    public int getAtkBonus(){
        return this.atkBonus;
    }

    public boolean getHasAc() {
        return this.hasAc;
    }

    public boolean getIsEquipped() {
        return this.isequipped;
    }

    public boolean getIsMagical() {
        return this.isMagical;
    }

    public int getSerialNumber(){
        return this.serialNumber;
    }





}
