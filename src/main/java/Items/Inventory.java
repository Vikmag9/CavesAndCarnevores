package Items;

import java.util.HashMap;
import java.util.List;

public class Inventory {
        List<InventoryItem> inventory;
        CoinBag coinBag;
        InventoryItemCreator inventoryItemCreator;
        InventoryItem item;



        public Inventory(List<InventoryItem> startingItems, int startingCoins) {
                this.inventory = startingItems;
                this.coinBag = new CoinBag(startingCoins);
                this.inventoryItemCreator = new InventoryItemCreator();
        }

        public void addItem(String type){
                this.inventoryItemCreator.createItem(type);
        }

        public void sellItem(int index){
               item = this.getInventoryItem(index);

        }

        private InventoryItem getInventoryItem(int index){
                return this.inventory.get(index);
        }

        private void removeItem(int index){
                this.inventory.remove(index);
        }
}