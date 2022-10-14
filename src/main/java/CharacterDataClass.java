import Items.Inventory;

import java.util.HashMap;

/*
This class has taken inspiration from the builder pattern. It behaves like a builder, but the builder pattern is not used.
However, it can in the future, which makes it extendable.
 */
public class CharacterDataClass implements CharacterDataCollection{
    String name;
    String jobName;
    String raceName;
    Inventory inventory;
    int level;
    String background;
    HashMap<StatName, Integer> stats;

    public CharacterDataClass setName(String name){
        this.name = name;
        return this;
    }

    public CharacterDataClass setJobName(String jobName){
        this.jobName = jobName;
        return this;
    }

    public CharacterDataClass setRaceName(String raceName){
        this.raceName = raceName;
        return this;
    }

    public CharacterDataClass setInventory(Inventory inventory){
        this.inventory = inventory;
        return this;
    }

    public CharacterDataClass setLevel(int level){
        this.level = level;
        return this;
    }

    public CharacterDataClass setBackground(String background){
        this.background = background;
        return this;
    }

    public CharacterDataClass setStats(HashMap<StatName, Integer> stats){
        this.stats = stats;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRaceName() {
        return this.raceName;
    }

    @Override
    public String getJobName() {
        return this.jobName;
    }

    @Override
    public String getBackground() {
        return this.background;
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public HashMap<StatName, Integer> getStats() {
        return this.stats;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
}
