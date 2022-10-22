package Model.Stats;

import java.util.ArrayList;
import java.util.Collections;

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
            listOfRolls.add(this.diceBag.rollDice(6));
            System.out.println(listOfRolls);
        }
        listOfRolls.remove(listOfRolls.indexOf(Collections.min(listOfRolls)));
        stat = 0;
        System.out.println("!" +listOfRolls);
        for(int u = 0; u<listOfRolls.size(); u++) {
            stat+= listOfRolls.get(u);
        }
        return stat;
    }

    private ArrayList<Integer> rollStats(){
        listOfStats = new ArrayList<Integer>();
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


