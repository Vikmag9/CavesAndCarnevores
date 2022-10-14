import Items.Inventory;
/*
This class has taken inspiration from the builder pattern. It behaves like a builder, but the builder pattern is not used.
However, it can in the future, which makes it extendable.
 */
public class CharacterDataClass {
    String name;
    String jobName;
    String raceName;
    Inventory inventory;
    int level;
    String background;

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
}
