package Items;

public class CoinBag {
    private int goldCoin;
    CoinBag(int startingCoins){
        this.goldCoin = startingCoins;
    }

    public void addCoin(int amount){
        this.goldCoin += amount;
    }

    public void takeCoins(int amount){
        this.goldCoin -= amount;
    }

    public int getCoinAmount(){
        return this.goldCoin;
    }

    public double getGoldCoin(){
        return this.goldCoin;
    }

    public void setCoins(int amount){
        this.goldCoin = amount;
    }

}
