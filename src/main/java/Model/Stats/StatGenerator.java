package Model.Stats;

import java.util.ArrayList;

/**
 * Class for generating a list of stats based on the strategy chosen and generating corresponding modifiers.
 */
public class StatGenerator {
    private StatStrategy strategy;

    public StatGenerator(){
        this.strategy = new RollStrategy();
    }

    /**
     * A setter for strategies.
     * @param strategy A string with the chosen strategy.
     */
    public void setStrategy(StatStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * A getter for stats based on the three strategies.
     * @return An ArrayList with 6 stats rolled based on the strategy.
     */
    public ArrayList<Integer> getListOfStats(){
        return this.strategy.getListOfStats();
    }

    /**
     * A method that calculates a modifier to a corresponding stat.
     * @param stat An int indicating the level of a particular stat.
     * @return The modifier for a certain stat.
     */
    public int getModifier(int stat){
        int statModifier;
        switch (stat) {
            case 1 -> statModifier = -5;
            case 2, 3 -> statModifier = -4;
            case 4, 5 -> statModifier = -3;
            case 6, 7 -> statModifier = -2;
            case 8, 9 -> statModifier = -1;
            case 12, 13 -> statModifier = 1;
            case 14, 15 -> statModifier = 2;
            case 16, 17 -> statModifier = 3;
            case 18, 19 -> statModifier = 4;
            case 20, 21 -> statModifier = 5;
            case 22, 23 -> statModifier = 6;
            case 24, 25 -> statModifier = 7;
            case 26, 27 -> statModifier = 8;
            case 28, 29 -> statModifier = 9;
            case 30 -> statModifier = 10;
            default -> statModifier = 0;
        }
        return statModifier;
    }

}

