package Model.Stats;

import java.util.ArrayList;
import java.util.List;

/**
 * The interface for the different strategies. Every class that is a stat-strategy must return a list of
 * stats.
 */
public interface StatStrategy {
    ArrayList<Integer> getListOfStats();


}