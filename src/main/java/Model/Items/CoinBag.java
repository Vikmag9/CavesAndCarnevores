package Model.Items;

public class CoinBag {
    private double goldCoin;

    CoinBag(double startingCoins){
        this.goldCoin = startingCoins;
    }

    void addCoin(double amount){
        this.goldCoin += amount;
    }

    void takeCoins(double amount){
        this.goldCoin -= amount;
    }

    double getCoinAmount(){
        return this.goldCoin;
    }

    public double getGoldCoin(){
        return this.goldCoin;
    }


}
