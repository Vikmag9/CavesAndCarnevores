package Model;

import Model.Items.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class that contains all the data for a character.
 * inspired by dataclasses which do not exist in java.
 * This class is used in the constructor in the character class.
 *
 * This class has taken inspiration from the builder pattern. It behaves like a builder, but the builder pattern is not used.
 * However, it can in the future, which makes it extendable.
 *
 * Has a collection of private attributes that are set using the different setters.
 */

public class CharacterDataClass implements CharacterDataCollection {

    String languages;
    String organisations;
    String earlierLife;
    String coreMemories;
    private String name;
    private String jobName;
    private String raceName;
    private Inventory inventory;
    private String alignment;
    private int level;
    private String background;
    private HashMap<StatName, Integer> stats;
    private ArrayList<ProficiencySkills> proficiencySkills;

    /**
     * Constructor for the CharacterDataClass.
     * Only sets the stats and the proficiency skills. The rest of the attributes are set using the different setters.
     */
    public CharacterDataClass(){
        this.stats = new HashMap<StatName, Integer>();
        this.proficiencySkills = new ArrayList<ProficiencySkills>();
    }

    /**
     * Sets the name of the character within the CharacterDataClass object.
     * @param name The name of the character.
     * @return The CharacterDataClass object.
     */
    public CharacterDataClass setName(String name){
        this.name = name;
        return this;
    }

    /**
     * Sets the job of the character within the CharacterDataClass object.
     * @param jobName The name of the job.
     * @return The CharacterDataClass object.
     */
    public CharacterDataClass setJobName(String jobName){
        this.jobName = jobName;
        System.out.println(jobName);
        return this;
    }

    /**
     * Sets the race of a character within the CharacterDataClass object.
     * @param raceName the name of the race of the character.
     * @return The CharacterDataClass object.
     */

    public CharacterDataClass setRaceName(String raceName){
        this.raceName = raceName;
        System.out.println(raceName);

        return this;
    }

    /**
     * Sets the inventory of the character within the CharacterDataClass object.
     * @param inventory The inventory of the character, as an inventory object.
     * @return The CharacterDataClass object.
     */

    public CharacterDataClass setInventory(Inventory inventory){
        this.inventory = inventory;
        return this;
    }

    /**
     * Sets the level of the character within the CharacterDataClass object.
     * @param level The level of the character, as an integer.
     * @return The CharacterDataClass object.
     */

    public CharacterDataClass setLevel(int level){
        this.level = level;
        return this;
    }

    /**
     * Sets the background of the character within the CharacterDataClass object.
     * @param background The background of the character, as a string.
     * @return The CharacterDataClass object.
     */

    public CharacterDataClass setBackground(String background){
        this.background = background;
        return this;
    }

    /**
     * Sets the stats of the character within the CharacterDataClass object.
     * @param stats The stats of the character, as a hashmap.
     * @return The CharacterDataClass object.
     */
    public CharacterDataClass setStats(HashMap<StatName, Integer> stats){
        this.stats = stats;
        return this;
    }

    /**
     * Sets the alignment of the character within the CharacterDataClass object.
     * @param alignment The alignment of the character, as a string.
     * @return The CharacterDataClass object.
     */

    public CharacterDataClass setAlignment(String alignment){
        this.alignment = alignment;
        return this;
    }

    /**
     * Sets the languages of the character within the CharacterDataClass object.
     * @param languages The languages of the character, as a string.
     * @return The CharacterDataClass object.
     */
    public CharacterDataClass setLanguages(String languages){
        this.languages = languages;
        return this;
    }

    /**
     * Sets the earlier life of the character within the CharacterDataClass object, a part of the lore for a character.
     * @param earlierLife The earlier life of the character, as a string.
     * @return The CharacterDataClass object.
     */

    public CharacterDataClass setEarlierLife(String earlierLife){
        this.earlierLife = earlierLife;
        return this;
    }

    /**
     * Sets the core memories of the character within the CharacterDataClass object, a part of the lore for a character.
     * @param coreMemories The core memories of the character, as a string.
     * @return The CharacterDataClass object.
     */
    public CharacterDataClass setCoreMemories(String coreMemories){
        this.coreMemories = coreMemories;
        return this;
    }

    /**
     * Sets the organisations of the character within the CharacterDataClass object, a part of the lore for a character.
     * @param organisations The organisations of the character, as a string.
     * @return The CharacterDataClass object.
     */
    public CharacterDataClass setOrganisations(String organisations){
        this.organisations = organisations;
        return this;
    }

    /**
     * Sets the strenght stat of the character within the CharacterDataClass object.
     * @param strength The strenght stat of the character, as an integer.
     */
    public void setStrength(int strength){
        stats.put(StatName.Strength, strength);
        System.out.println(strength);
    }

    /**
     * Sets the Intelligence stat of the character within the CharacterDataClass object.
     * @param intelligence The Intelligence stat of the character, as an integer.
     */
    public void setIntelligence(int intelligence){
        stats.put(StatName.Intelligence, intelligence);
        System.out.println(intelligence);

    }

    /**
     * Sets the constitution stat of the character within the CharacterDataClass object.
     *
     * @param constitution The constitution stat of the character, as an integer.
     */
    public void setConstitution(int constitution){
        stats.put(StatName.Intelligence, constitution);
    }

    /**
     * Sets the Wisdom stat of the character within the CharacterDataClass object.
     * @param wisdom The Wisdom stat of the character, as an integer.
     */
    public void setWisdom(int wisdom){
        stats.put(StatName.Wisdom, wisdom);
        System.out.println(wisdom);

    }

    /**
     * Sets the Proficiency Skills of the character within the CharacterDataClass object.
     * @param addOrRemove A boolean that determines if the proficiency skill should be added or removed. True for add, false for remove.
     * @param statName The name of the proficiency skill to be added or removed.
     */
    public void setProficiencies(Boolean addOrRemove, ProficiencySkills statName){
        if (addOrRemove) {
            this.proficiencySkills.add(statName);
            System.out.println(proficiencySkills);
        }
        else{
            this.proficiencySkills.remove(statName);
            System.out.println(proficiencySkills);


        }
    }

    /**
     * Sets the charisma stat of the character within the CharacterDataClass object.
     * @param charisma The charisma stat of the character, as an integer.
     */
    public void setCharisma(int charisma){
        stats.put(StatName.Charisma, charisma);
    }

    /**
     * Sets the Dexterity stat of the character within the CharacterDataClass object.
     * @param dexterity The Dexterity stat of the character, as an integer.
     */
    public void setDexterity(int dexterity){
        stats.put(StatName.Dexterity, dexterity);
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

    @Override
    public String getAlignment() {
        return this.alignment;
    }

    @Override
    public String getLanguages() {
        return this.languages;
    }

    @Override
    public String getOrganisations() {
        return this.organisations;
    }

    @Override
    public String getEarlierLife() {
        return this.earlierLife;
    }
}
