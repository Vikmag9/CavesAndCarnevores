package Items;

import java.util.HashMap;
import java.util.List;

public class Inventory {
        HashMap<String, InventoryItem> inventory;
        CoinBag coinBag;
        InventoryItemCreator inventoryItemCreator;
        InventoryItem item;
        int value;



        public Inventory(HashMap<String, InventoryItem> startingItems, int startingCoins) {
                this.inventory = new HashMap<String, InventoryItem>();
                inventory.putAll(startingItems);
                this.coinBag = new CoinBag(startingCoins);
                this.inventoryItemCreator = new InventoryItemCreator();
        }

        public void addItem(String key, InventoryItem item){
                inventory.put(key, item);
        }

        public void sellItem(String key){
               item = inventory.get(key);
               value = item.getItemValue();
               coinBag.addCoin(value);
               inventory.remove(key);

        }


}