import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Stats {
    int inte;
    int cha;
    int wis;
    int con;
    int dex;
    int str;
    List<Integer> listOfRolls;
    DiceBag diceBag = new DiceBag();

    public Stats(){
        this.inte = 0;

    }

    private void rollStat(){
        listOfRolls = new ArrayList<Integer>();
        for(int i = 0; i < 4; i++){
            listOfRolls.add(diceBag.rollDice(6));
        }
    }
}


