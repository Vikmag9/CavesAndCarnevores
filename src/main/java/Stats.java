import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Stats {
    List<Integer> listOfRolls;
    List<Integer> listOfStats;
    DiceBag diceBag;
    int stat;

    public Stats(){
         diceBag = new DiceBag();
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

    private void rollStats(){
        for(int i= 1; i < 7; i++)
            listOfStats.add(this.rollOneStat());
    }


    public List<Integer> getStats(){
        return listOfStats;
    }
}


