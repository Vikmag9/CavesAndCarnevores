package Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
        HashMap<String, InventoryItem> inventory;
        CoinBag coinBag;
        InventoryItemFactory inventoryItemFactory;



        Inventory(HashMap<String, InventoryItem> startingItems, int startingCoins) {
                this.inventory = startingItems;
                this.coinBag = new CoinBag(startingCoins);
                this.inventoryItemFactory = new InventoryItemFactory();
        }

        public void addItem(){
                this.inventoryItemFactory.createItem();
        }
}