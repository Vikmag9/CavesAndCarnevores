import Items.InventoryItem;
import Items.Clothing;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Collections.emptyList;

public class Character {
    private String name;
    private Race race;
    private Job job; // Job represents a D&D Class since "class" is otherwise a keyword in java.
    private List<Feature> feats;
    private int health;
    private int xp;
    private int armorClass;
    private List<InventoryItem> inventory;
    private List<Clothing> wearables;
    private Map<String, List<String>> proficiencies;



    public Character(String name, Race race, Job job, List<Feature> feats, List<InventoryItem> inventory){
        this.name = name;
        this.race = race;
        this.job = job;
        this.health = calculateHealth();
        this.feats = assembleFeats();
        this.inventory = inventory;
        this.armorClass = calculateAC();

    }





    private int calculateAC() {

        AtomicInteger ac = new AtomicInteger(0);
        inventory.forEach(item -> {
            if (item instanceof Clothing) {
                 if ( ((Clothing) item).isEquipped()) {
                    ac.set(((Clothing) item).getArmorClass());
                }
            }
        });
        return ac.get();
    }

    private int calculateHealth() {
        return ((this.job.getHitDie()/2)+1) /*TODO + constitution modifier*/ * this.job.getLevel();
    }
    
    private List<Feature> assembleFeats() {

        //TODO Add features from race and background etc
        return this.job.getFeatures();
    }
    // --------------------------------- GETTERS AND SETTERS -------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setFeats(List<Feature> feats) {
        this.feats = feats;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public Job getJob() {
        return job;
    }

    public List<Feature> getFeats() {
        return feats;
    }

    public int getHealth() {
        return health;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }


}
