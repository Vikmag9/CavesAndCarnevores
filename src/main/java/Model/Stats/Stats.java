package Model.Stats;

import java.util.ArrayList;

public class Stats {
    StatGenerator statGenerator;
    public Stats(){
        this.statGenerator = new StatGenerator();
    }

    public void chooseStrategy(String strategy){
        System.out.println("Stat");
        switch (strategy) {
            case ("Roll drop one") -> statGenerator.setStrategy(new RollStrategy());
            case ("Array") -> statGenerator.setStrategy(new ArrayStrategy());
            case ("Nightmare") -> statGenerator.setStrategy(new NightmareStrategy());
        }
    }

    public ArrayList<Integer> getStats(){
        return this.statGenerator.getListOfStats();
    }

}
