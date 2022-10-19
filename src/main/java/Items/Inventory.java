package Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {

        List<InventoryItem> inventory;
        private CoinBag coinBag;
        InventoryItem item;
        int value;


    public double getCoinAmount(){
           return this.coinBag.getCoinAmount();
    }

        public Inventory(double startingCoins) {
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
        return this.inventory;

    }

    public InventoryItem getItem(int key){
        return inventory.get(key);
    }
    public List<InventoryItem> getCompleteInventory() {
        return this.inventory;
    }

    public CoinBag getCoinBag() {
        return coinBag;
    }


}