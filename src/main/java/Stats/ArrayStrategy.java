package Stats;

import java.util.ArrayList;
import java.util.List;

public class ArrayStrategy implements StatStrategy{
    ArrayList<Integer> listOfStats;

    @Override
    public ArrayList<Integer> getListOfStats() {
        listOfStats = new ArrayList<Integer>(List.of(15, 14, 13, 12, 10, 8));
        System.out.println("array");
        return listOfStats;
    }
}
