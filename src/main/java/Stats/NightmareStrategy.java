package Stats;

import java.util.ArrayList;

public class NightmareStrategy implements StatStrategy{
    DiceBag diceBag;
    int roll;
    ArrayList<Integer> listOfStats;
    int stat;

    public NightmareStrategy(){
        this.diceBag = new DiceBag();
    }

    private int rollStat(){
        roll = this.diceBag.rollDice(20);
        return roll;
    }

    private ArrayList<Integer> rollStats() {
        listOfStats = new ArrayList<Integer>();
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
