import java.util.List;

public class Character {

    private FileManager fm = new FileManager();
    private String name;
    private Race race;
    private Job job; // Job represents a D&D Class since "class" is otherwise a keyword in java.
    private List<Feature> feats;
    private int health;
    private int armorClass;
    private List<InventoryItem> inventory;


    public Character(String name, Race race, Job job, List<Feature> feats, List<InventoryItem> inventory){
        this.name = name;
        this.race = race;
        this.job = job;
        this.feats = feats;
        this.inventory = inventory;

    }

    public void loadJob(){
        // Switch case, checks which job has been selected. Delegates loading of class based on which class is chosen.
    }
}
