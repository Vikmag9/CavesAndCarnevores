package Items;

public class CoinBag {
    private int goldCoin;
    private int startingCoins;

    CoinBag(int startingCoins){
        this.startingCoins = startingCoins;
    }

    public void addCoin(int amount){
        this.goldCoin += amount;
    }

    public void takeCoins(int amount){
        this.goldCoin -= amount;
    }
}
