package Stats;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for getting a set list of 6 values to be placed in the Stats part of the Wizard.
 */
public class ArrayStrategy implements StatStrategy{
    ArrayList<Integer> listOfStats;

    @Override
    public ArrayList<Integer> getListOfStats() {
        listOfStats = new ArrayList<>(List.of(15, 14, 13, 12, 10, 8));
        System.out.println("array");
        return listOfStats;
    }

}
