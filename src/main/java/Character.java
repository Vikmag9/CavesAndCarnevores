import Items.Inventory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Character implements CharacterDataCollection{
    private String name;
    private Race race;
    private Job job; // Job represents a D&D Class since "class" is otherwise a keyword in java.
    private List<Feature> feats;
    private int health;
    private int xp;
    private int level;
    private int armorClass;
    private Inventory inventory;
    private Map<String, List<String>> proficiencies;
    private String background;
    private HashMap<StatName, Integer> stats;
    private String raceName;
    private String jobName;



    public Character(CharacterDataCollection data, int level) throws IOException, ClassNotFoundException {
        this.race = new Race(data.getName());
        this.raceName = data.getRaceName();
        this.job = new Job(data.getJobName());
        this.jobName = data.getJobName();
        this.background = data.getBackground();
        this.level = level;
        this.health = calculateHealth();
        this.feats = assembleFeats();
        this.inventory = data.getInventory();
        this.armorClass = calculateAC();
        this.stats = data.getStats();


    }




    private int calculateAC() {
        AtomicInteger ac = new AtomicInteger(0);
        AtomicInteger additionalAC = new AtomicInteger(0);
        this.inventory.getInventory().forEach((value) -> {
            if (value.getItemType().equals("Armour") && value.getHasAc() && value.getIsEquipped()) {
                ac.set(value.getAc());
            }
            else if (!value.getItemType().equals("Armour") && value.getHasAc() && value.getIsEquipped()) {
                additionalAC.getAndAdd(value.getAc());
            }
        });
        return (ac.get() + additionalAC.get());
    }

    private int calculateHealth() {
        return ((this.job.getHitDie()/2)+1) /*TODO + constitution modifier*/ * getLevel();
    }
    
    private List<Feature> assembleFeats() {
        List<Feature> feats = this.job.getFeatures();
        feats.addAll(this.race.getTraits());
        //TODO Add features from background etc
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

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
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

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public HashMap<StatName, Integer> getStats() {
        return this.stats;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
