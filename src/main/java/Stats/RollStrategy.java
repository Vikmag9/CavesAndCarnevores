package Stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RollStrategy implements StatStrategy{
    ArrayList<Integer> listOfRolls;
    ArrayList<Integer> listOfStats;
    DiceBag diceBag;
    int stat;

    public RollStrategy(){
         this.diceBag = new DiceBag();
    }

    private int rollOneStat(){
        listOfRolls = new ArrayList<Integer>();
        for(int i = 0; i < 4; i++){
            listOfRolls.add(diceBag.rollDice(6));
        }
        listOfRolls.remove(listOfRolls.indexOf(Collections.min(listOfRolls)));

        for(int i : listOfRolls) {
            stat = 0;
            stat+= listOfRolls.get(i);
        }
        return stat;
    }

    private ArrayList<Integer> rollStats(){
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


