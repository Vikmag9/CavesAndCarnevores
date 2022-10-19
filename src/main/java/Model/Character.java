package Model;

import Model.Items.Inventory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A class that represents a character in the game.
 * Implements the CharacterDataCollection interface to allow for creating a character with the nessesary data, such as name, job, stats, etc.
 * has a set of private fields that are used to store the data of the character.
 */

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

    /**
     * Constructor for the character class. All fields are required to create a character.
     * Also makes a copy of the CharacterDataCollection object to avoid modifying the original object, and then sets the attributes to the values of the copy.
     * @param data A collection of the data that is needed for a character. Implements the CharacterDataCollection interface.
     * @param level The level of the character, as an Integer.
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws CloneNotSupportedException
     */

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


    /**
     * Calculates the AC of the character.
     * Based on the D&D 5e rules, the AC is calculated as 10 + Dexterity modifier + Armor bonus.
     * Also accounts for items that have an AC modifier.
     * @return int The armourclass of the character.
     */

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

    /**
     * Sets the name of the character.
     * Used when creating a new character.
     * @param name The name of the character as a String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the race of the character. (e.g. Human, Elf, Dwarf, etc.)
     * Used when creating a new character.
     * @param race The name of the character as a String.
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     * Sets the job of the character. (e.g. Fighter, Wizard, Rogue, etc.)
     * Used when creating a new character.
     * job is what in D&D is called a class, but has been renamed since class is a keyword in java.
     * @param job The name of the character as a String.
     */
    public void setJob(Job job) {
        this.job = job;
    }

    /**
     * sets the fetures of the character.
     * collects features from a characters race and class under the same umbrella.
     * ex. an elf fighter would have the features of both an elf (ex. darkvision) and a fighter (ex. action surge).
     * @param feats A list of features that the character has.
     */
    public void setFeats(List<Feature> feats) {
        this.feats = feats;
    }

    /**
     * Sets the health (number of hitpoints) of the character.
     * Used when creating a new character.
     * @param health The health of the character as an Integer.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets the Armor Class of the character.
     * Used when creating a new character.
     * Uses an already calculated AC that includes both armour and items with an ac modifier, that is passed as a parameter.
     * @param armorClass The armor class of the character as an Integer.
     */

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    /**
     * Sets the inventory of the character.
     * Used when creating a new character.
     *
     * @param inventory The inventory of the character as an Inventory object.
     */

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

    /**
     * Sets the level of the character.
     * Used when creating a new character or leveling up an existing character.
     * @param level The level of the character as an Integer.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    public String getAlignment() {
        return alignment;
    }

    /**
     * Sets the alignment of the character.
     * Used when creating a new character.
     * @param alignment The alignment of the character as a String.
     */

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

}
