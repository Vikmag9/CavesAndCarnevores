package Items;

import java.util.HashMap;
import java.util.List;

public class Inventory {

        HashMap<Integer, InventoryItem> inventory;
        CoinBag coinBag;
        InventoryItem item;
        int value;
        int serialNumber;



        public Inventory(int startingCoins) {
                this.inventory = new HashMap<Integer, InventoryItem>();
                this.coinBag = new CoinBag(startingCoins);
                this.serialNumber = 1;
        }

        public void addItem(InventoryItem item){
                this.serialNumber += 1;
                item.setSerialNumber(this.serialNumber);
                inventory.put(serialNumber, item);
        }

        public void sellItem(int key){
               item = inventory.get(key);
               value = item.getItemValue();
               coinBag.addCoin(value);
               inventory.remove(key);

        }

    public HashMap<Integer, InventoryItem> getInventory() {
        return inventory;
    }


}