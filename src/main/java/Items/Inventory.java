package Items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
        List<InventoryItem> inventory;
        CoinBag coinBag;



        Inventory(List<InventoryItem> startingItems, int startingCoins) {
                inventory = new ArrayList<InventoryItem>();
                this.coinBag = new CoinBag(startingCoins);
        }
        public void sellItem(){

        }

        public void buyItem(){

        }
}