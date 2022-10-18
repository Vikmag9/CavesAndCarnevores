package Stats;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements an Array strategy for rolling stats.
 */
public class ArrayStrategy implements StatStrategy{
    ArrayList<Integer> listOfStats;

    /**
     * A method that creates an ArrayList with a set of values, used when choosing the Array strategy when rolling stats in the Character Creation Wizard.
     * @return An ArrayList with the values 15, 14, 13, 12, 10, and 8.
     */
    @Override
    public ArrayList<Integer> getListOfStats() {
        listOfStats = new ArrayList<>(List.of(15, 14, 13, 12, 10, 8));
        System.out.println("array");
        return listOfStats;
    }
}
