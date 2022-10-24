package Model.Stats;

import java.util.ArrayList;

/**
 * A class that implements the Nightmare Strategy, which is a way to roll a character's stats.
 */
public class NightmareStrategy implements StatStrategy{
    DiceBag diceBag;
    int roll;
    ArrayList<Integer> listOfStats;
    int stat;

    public NightmareStrategy(){
        this.diceBag = new DiceBag();
    }
    /**A method that rolls a 20-sided die*/
    private int rollStat(){
        roll = this.diceBag.rollDice(20);
        return roll;
    }
    /**Returns an array that contains 6 die-rolls*/
    private ArrayList<Integer> rollStats() {
        listOfStats = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            stat = rollStat();
            listOfStats.add(stat);
        }
        return listOfStats;
    }

    @Override
    public ArrayList<Integer> getListOfStats() {
        listOfStats = rollStats();
        return listOfStats;
    }

}
