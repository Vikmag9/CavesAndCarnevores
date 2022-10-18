package Model.Stats;

import java.util.ArrayList;

public class StatGenerator {
    private StatStrategy strategy;

    public StatGenerator(){
        this.strategy = new RollStrategy();
    }

    public void setStrategy(StatStrategy strategy) {
        this.strategy = strategy;
    }

    public ArrayList<Integer> getListOfStats(){
        return this.strategy.getListOfStats();
    }
}

