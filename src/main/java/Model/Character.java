package Model;

import Items.Inventory;
import Model.CharacterDataCollection;
import Model.Job;
import Model.StatName;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Character implements CharacterDataCollection {
    private String name;
    private Race race;
    private Job job; // Model.Job represents a D&D Class since "class" is otherwise a keyword in java.
    private List<Feature> feats;
    private int health;
    private String Alignment;
    private int xp;
    private int level;
    private int armorClass;
    private String alignment;
    private Inventory inventory;
    private Map<String, List<String>> proficiencies;
    private String background;
    private HashMap<StatName, Integer> stats;
    private String raceName;
    private String jobName;
    private String languages;
    private String organisation;
    private String earlierLife;

    public Character(CharacterDataCollection data, int level) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        CharacterDataCollection characterData = data; // Creates copy of data to avoid modifying original data
        this.name = characterData.getName();
        this.alignment = characterData.getAlignment();
        this.race = new Race(characterData.getRaceName());
        this.raceName = characterData.getRaceName();
        this.job = new Job(characterData.getJobName());
        this.jobName = characterData.getJobName();
        this.background = characterData.getBackground();
        this.level = level;
        this.stats = characterData.getStats();
        this.health = calculateHealth();
        this.feats = assembleFeats();
        this.inventory = characterData.getInventory();
        this.armorClass = calculateAC();

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
        return (((this.job.getHitDie()/2)+1) * getLevel()) + ((this.getStats().get(StatName.Constitution)-10)/2);
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

    @Override
    public String getLanguages() {
        return this.languages;
    }

    @Override
    public String getOrganisations() {
        return this.organisation;
    }

    @Override
    public String getEarlierLife() {
        return this.earlierLife;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
}
