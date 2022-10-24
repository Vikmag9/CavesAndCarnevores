package Model.Stats;

import java.util.ArrayList;

/**
 * A class for choosing the different ways to roll stats and getting those stats. The module, Stats, implements
 * the strategy pattern, in which the class Stats chooses the strategy depending on the user input.
 */
public class Stats {
    StatGenerator statGenerator;
    public Stats(){
        this.statGenerator = new StatGenerator();
    }

    /**
     * A method that chooses one of the three available strategies for rolling stats in the application based in the
     * input it receives.
     * @param strategy A string: either Roll Drop One, Array, and Nightmare.
     */
    public void chooseStrategy(String strategy){
        System.out.println("Stat");
        switch (strategy) {
            case ("Roll drop one") -> statGenerator.setStrategy(new RollStrategy());
            case ("Array") -> statGenerator.setStrategy(new ArrayStrategy());
            case ("Nightmare") -> statGenerator.setStrategy(new NightmareStrategy());
        }
    }

    /**
     * A getter for stats.
     * @return a list of stats from StatGenerator
     */
    public ArrayList<Integer> getStats(){
        return this.statGenerator.getListOfStats();
    }

}
