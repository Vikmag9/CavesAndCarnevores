package Model;

/**
 * A class for representing the features a character has.
 * Model.Feature is an umbrella term for traits and features from a characters race and class.
 */
public class Feature {
    private String name;
    private String desc;
    private int levelPrerequisites;
    public Feature(String name, String desc, int prerequisites) {
        this.name = name;
        this.desc = desc;
        this.levelPrerequisites = prerequisites;
    }

    /**
     * A method to get the level requirements for a feature.
     * @return the level requirements for a feature, as an integer.
     */
    public int getLevel() {
        return this.levelPrerequisites;
    }

    public String getName(){
        return this.name;
    }

    public String getDesc() {
        return desc;
    }
}
