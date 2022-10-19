package Model.Stats;

import java.util.ArrayList;

public class Stats {
    StatGenerator statGenerator;
    public Stats(){
        this.statGenerator = new StatGenerator();
    }

    public void chooseStrategy(String strategy){
        System.out.println("Stat");
        switch(strategy){
            case("Roll drop one"):
                statGenerator.setStrategy(new RollStrategy());
                System.out.println("Roll");
                break;
            case("Array"):
                statGenerator.setStrategy(new ArrayStrategy());
                System.out.println("Array1");
                break;
            case("Nightmare"):
                statGenerator.setStrategy(new NightmareStrategy());
                System.out.println("Nightmare");
                break;



        }
    }

    public ArrayList<Integer> getStats(){
        return this.statGenerator.getListOfStats();
    }

}
