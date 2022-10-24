package Model;

import Model.Items.Inventory;

import java.util.*;
import java.io.IOException;
import java.util.ArrayList;
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
    private Map<Proficiencies, List<String>> proficiencies;
    private String background;
    private HashMap<StatName, Integer> stats;
    private String raceName;
    private String jobName;
    private String languages;
    private String organisation;
    private String earlierLife;
    private String notes;
    private ArrayList<ProficiencySkills> proficiencySkills;
    int modifier;
    HashMap<StatName, Integer> modifiers;

    /**
     * Constructor for the Model.Character class.
     *
     * @param data The data to be used to create the character, as an object that implements the Model.CharacterDataCollection interface.
     * @param level The level of the character, as an integer.
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws CloneNotSupportedException
     */

    public Character(CharacterDataCollection data, int level) {
        CharacterDataCollection characterData = data; // Creates copy of data to avoid modifying original data
        this.name = characterData.getName();
        this.alignment = characterData.getAlignment();
        System.out.println(characterData.getRaceName());
        this.race = new Race(characterData.getRaceName());
        this.raceName = characterData.getRaceName();
        this.job = new Job(characterData.getJobName());
        this.jobName = characterData.getJobName();
        this.xp = characterData.getXp();
        this.background = characterData.getBackground();
        this.notes = characterData.getNotes();
        this.organisation = characterData.getOrganisations();
        this.earlierLife = characterData.getEarlierLife();
        this.level = level;
        this.proficiencySkills = characterData.getProficiencySkills();
        System.out.println(characterData.getStats());
        this.stats = characterData.getStats();
        this.modifiers = calculateModifiers();
        this.health = calculateHealth();
        this.feats = assembleFeats();
        this.inventory = new Inventory(10);
        this.armorClass = calculateAC();
        this.proficiencies = assembleProficiencies();


    }


    /**
     * Calculates the character's armor class.
     * Based on the character's dexterity modifier and the armor they are wearing, as per the rules of dnd (5e).
     * Also accounts for if the character has any items that modify their armor class.
     * @return The character's armor class, as an integer.
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

    /**
     * Calculates the character's health.
     * Based on the character's constitution modifier and the character's level, as per the rules of dnd (5e).
     * Also based on the characters job (class in dnd) to determine the hit die of the character.
     * @return The character's health, as an integer.
     */
    private int calculateHealth() {
        return (((this.job.getHitDie()/2)+1) * getLevel()) + ((this.getStats().get(StatName.Constitution)-10)/2);
    }

    public HashMap<StatName, Integer> calculateModifiers(){
        modifiers = new HashMap<StatName, Integer>();
        for(StatName statname : StatName.values()){
            int stat = this.stats.get(statname);
            double modifierDouble = (stat-10)/2;
            int modifier = (int) Math.floor(modifierDouble);
            modifiers.put(statname, modifier);
        }
        return modifiers;
    }
    /**
     * Assembles the character's feats.
     * feats is an umbrella-term for the different traits and abilities that a character has depending on their race and class.
     * First fetches the matching feats and then removes the ones that belong to any levels higher than the character's level.
     * @return A list of the character's feats.
     */
    private List<Feature> assembleFeats() {
        List<Feature> feats = this.job.getFeatures();
        feats.addAll(this.race.getTraits());
        List<Feature> characterFeatures = new ArrayList<>();
        for (Feature feat : feats) {
            if (feat.getLevel() <= this.level) {
                characterFeatures.add(feat);
            }
        }
        return characterFeatures;
    }




    private HashMap<Proficiencies, List<String>> assembleProficiencies(){
        HashMap<Proficiencies, List<String>> proficiencies = new HashMap<>();
        proficiencies.put(Proficiencies.Armor, Collections.emptyList());
        proficiencies.put(Proficiencies.Weapons, Collections.emptyList());
        proficiencies.put(Proficiencies.Tools, Collections.emptyList());
        proficiencies.put(Proficiencies.SavingThrows, Collections.emptyList());
        proficiencies.put(Proficiencies.Skills, Collections.emptyList());
        proficiencies.put(Proficiencies.Other, Collections.emptyList());


        Map jobProfs = this.job.getProficiencies();
        Map raceProfs = this.race.getProficiencies();


        jobProfs.forEach((key, value) -> {
            if (proficiencies.containsKey(key) && value != null) {
                proficiencies.put(Proficiencies.valueOf(key.toString()), (List<String>) value);
            }
        });

        raceProfs.forEach((key, value) -> {
            if (proficiencies.containsKey(key) && value != null) {
                List<String> collection = proficiencies.get(key);
                collection.addAll((List<String>) value);
                proficiencies.put(Proficiencies.valueOf(key.toString()), collection);
            }
        });
        return proficiencies;
    }

    // --------------------------------- GETTERS AND SETTERS -------------------------------------

    /**
     * Sets the character's name from a string, nessesary for creating a character from the GUI.
     * @param name the name of the character.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the characters race from a race object
     * necessary for creating a character from the GUI.
     * @param race the race of the character, as a race object.
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     * Sets the characters job from a job object
     * @param job the job of the character, as a job object.
     */
    public void setJob(Job job) {
        this.job = job;
    }

    /**
     * Sets the characters feats from a list of feats.
     * @param feats the feats of the character, as a list of feats.
     */
    public void setFeats(List<Feature> feats) {
        this.feats = feats;
    }

    /**
     * Sets the characters health from an integer.
     * @param health the health of the character, as an integer.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets the characters armor class from an integer.
     * @param armorClass the armor class of the character, as an integer.
     */
    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    /**
     * Sets the inventory of the character from an inventory object.
     * @param inventory the inventory of the character, as an inventory object.
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setProficiencySkills(ArrayList<ProficiencySkills> list){
        this.proficiencySkills = list;
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

    /**
     * Sets the characters xp from an integer.
     * @param xp the xp of the character, as an integer.
     */
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

    @Override
    public String getNotes() {
        return this.notes;
    }

    @Override
    public ArrayList<ProficiencySkills> getProficiencySkills() {
        return this.proficiencySkills;
    }

    /**
     * Sets the characters level from an integer.
     * @param level the level of the character, as an integer.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    public String getAlignment() {
        return alignment;
    }

    /**
     * Sets the characters alignment from a string.
     * @param alignment the alignment of the character, as a string.
     */
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public List<Feature> getFeatures() {
        return this.feats;
    }

    public Map<Proficiencies, List<String>> getProficiencies(){
        return this.proficiencies;
    }

    public void setStrength(int strength){
        stats.put(StatName.Strength, strength);
    }
    public void setConstitution(int constitution){
        this.stats.put(StatName.Constitution, constitution);
    }

    public void setWisdom(int wisdom){
        this.stats.put(StatName.Wisdom, wisdom);
        System.out.println(wisdom);
    }

    public void setCharisma(int charisma){
        this.stats.put(StatName.Charisma, charisma);
    }

    public void setDexterity(int dexterity){
        this.stats.put(StatName.Dexterity, dexterity);
    }

    public void setIntelligence(int intelligence){
        this.stats.put(StatName.Intelligence, intelligence);
        System.out.println(intelligence);

    }
}
