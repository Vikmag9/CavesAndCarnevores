package Stats;

public class StatGenerator {
    private StatStrategy strategy;

    public StatGenerator(){
        this.strategy = strategy;
    }

    public void setStrategy(StatStrategy strategy) {
        this.strategy = strategy;
    }

    public void getListOfStats(){
        this.strategy.getListOfStats();
    }
}

