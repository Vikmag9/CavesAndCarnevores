import Items.Inventory;
/*
This class has taken inspiration from the builder pattern. It behaves like a builder, but the builder pattern is not used.
However, it can in the future, which makes it extensible.
 */
public class CharacterDataClass {
    String name;
    Job job;
    Race race;
    Inventory inventory;
    int level;
    String background;

    public CharacterDataClass setName(String name){
        this.name = name;
        return this;
    }

    public CharacterDataClass setJob(Job job){
        this.job = job;
        return this;
    }

    public CharacterDataClass setRace(Race race){
        this.race = race;
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
