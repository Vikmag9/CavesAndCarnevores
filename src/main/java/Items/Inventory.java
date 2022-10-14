package Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {

        List<InventoryItem> inventory;
        CoinBag coinBag;
        InventoryItem item;
        int value;
        int serialNumber;



        public Inventory(int startingCoins) {
                this.inventory = new ArrayList<InventoryItem>();
                this.coinBag = new CoinBag(startingCoins);
        }

        public void addItem(InventoryItem item){
                inventory.add(item);
        }

        public void sellItem(int key){
               item = inventory.get(key);
               value = item.getItemValue();
               coinBag.addCoin(value);
               inventory.remove(key);

        }

    public List<InventoryItem> getInventory() {
        return inventory;

    }

    public InventoryItem getItem(int key){
        return inventory.get(key);
    }
    public List<InventoryItem> getCompleteInventory() {
        return inventory;
    }


}