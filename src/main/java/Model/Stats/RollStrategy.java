package Model.Stats;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that implements the Roll Drop One strategy for rolling character stats.
 */
public class RollStrategy implements StatStrategy{
    ArrayList<Integer> listOfRolls;
    ArrayList<Integer> listOfStats;
    DiceBag diceBag;
    int stat;

    public RollStrategy(){
         this.diceBag = new DiceBag();
    }

    /** Rolls 4 d6 dice and removes the lowest number. The sum is one of the generated stats. Returns one out of 6
    stats. */
    private int rollOneStat(){
        listOfRolls = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            listOfRolls.add(DiceBag.rollDice(6));
            System.out.println(listOfRolls);
        }
        listOfRolls.remove(Collections.min(listOfRolls));
        stat = 0;
        System.out.println("!" +listOfRolls);
        for (Integer listOfRoll : listOfRolls) {
            stat += listOfRoll;
        }
        return stat;
    }
    /**
     * Calls a method that rolls 6 stats. Each stat is calculated by rolling 4 d6 dice, removing the lowest number, and
     * adding the rest to a sum. The sum is one stat. This method repeats itself 6 times.
     * @return A list of 6 stats rolled according to the Roll One Drop strategy.
     */
    private ArrayList<Integer> rollStats(){
        listOfStats = new ArrayList<>();
        for(int i= 1; i < 7; i++)
            listOfStats.add(this.rollOneStat());
        return listOfStats;
    }


    @Override
    public ArrayList<Integer> getListOfStats(){
        listOfStats = rollStats();
        return listOfStats;
    }

}


