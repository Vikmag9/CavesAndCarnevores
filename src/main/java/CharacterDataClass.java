import Items.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

/*
This class has taken inspiration from the builder pattern. It behaves like a builder, but the builder pattern is not used.
However, it can in the future, which makes it extendable.
 */

/**
 * This class is inspired by the builder pattern and by dataclasses in for example python.
 * Instead of adding the parts of a character to a list, a dataclass is used.
 * We choose not to implement the builder pattern completely, since the class cannot take in different parameters like the pattern requires.
 * However, it can be implemented in the future, which makes it extendable.
 */
public class CharacterDataClass implements CharacterDataCollection{

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
    ArrayList<ProficiencySkills> proficiencySkills;
    private int xp;

    /**
     * constructor for the CharacterDataClass.
     */
    CharacterDataClass(){
        this.stats = new HashMap<StatName, Integer>();
        this.proficiencySkills = new ArrayList<>();

    }

    /**
     *Sets the name of the character in the CharacterDataClass.
     * @param name the characters name, as a string.
     * @return the CharacterDataClass object.
     */

    public CharacterDataClass setName(String name){
        this.name = name;
        return this;
    }

    /**
     * Sets the job of the character in the CharacterDataClass.
     * @param jobName the job of the character, as a string.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setJobName(String jobName){
        this.jobName = jobName;
        return this;
    }

    /**
     * Sets the name of the race that a character has, in the CharacterDataClass.
     * @param raceName the name of the character, as a string.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setRaceName(String raceName){
        this.raceName = raceName;
        return this;
    }

    /**
     * Sets the inventory of the character in the CharacterDataClass.
     * @param inventory the inventory of this character, as an Inventory object.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setInventory(Inventory inventory){
        this.inventory = inventory;
        return this;
    }

    /**
     * Sets the level of the character in the CharacterDataClass.
     * @param level the level of the character, as an integer.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setLevel(int level){
        this.level = level;
        return this;
    }

    /**
     * Sets the background of the character in the CharacterDataClass.
     * @param background the background of the character, as a string.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setBackground(String background){
        this.background = background;
        return this;
    }

    /**
     * Sets the Stats of the character in the CharacterDataClass.
     * @param stats the stats of the character, as a Map of the StatName and Integer with the corresponding stats value.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setStats(HashMap<StatName, Integer> stats){
        this.stats = stats;
        return this;
    }

    /**
     * Sets the alignment of the character in the CharacterDataClass.
     * @param alignment the alignment of the character, as a string.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setAlignment(String alignment){
        this.alignment = alignment;
        return this;
    }

    public CharacterDataClass setXp(int xp){
        this.xp = xp;
        return this;
    }

    /**
     * Sets the languages of the character in the CharacterDataClass.
     * @param languages the languages of the character, as a string.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setLanguages(String languages){
        this.languages = languages;
        return this;
    }

    /**
     * Sets the earlier life of the character in the CharacterDataClass.
     * The earlier life is a part of the lore around the character.
     * @param earlierLife the earlier life of the character, as a string.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setEarlierLife(String earlierLife){
        this.earlierLife = earlierLife;
        return this;
    }

    /**
     * Sets the core memories of the character in the CharacterDataClass.
     * The memories is a part of the lore around the character.
     * @param coreMemories the core memories of the character, as a string.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setCoreMemories(String coreMemories){
        this.coreMemories = coreMemories;
        return this;
    }

    /**
     * Sets the organisations of the character in the CharacterDataClass.
     * The organisations is a part of the lore around the character.
     * @param organisations the organisations of the character, as a string.
     * @return the CharacterDataClass object.
     */
    public CharacterDataClass setOrganisations(String organisations){
        this.organisations = organisations;
        return this;
    }

    /**
     * Sets the Strength stat of the character in the CharacterDataClass.
     * @param strength the strength stat of the character, as an integer.
     */
    public void setStrength(int strength){
        stats.put(StatName.Strength, strength);
        System.out.println(strength);
    }

    /**
     * Sets the Intelligence stat of the character in the CharacterDataClass.
     * @param intelligence the intelligence stat of the character, as an integer.
     */
    public void setIntelligence(int intelligence){
        stats.put(StatName.Intelligence, intelligence);
        System.out.println(intelligence);

    }

    /**
     * Sets the constitution stat of the character in the CharacterDataClass.
     * @param constitution the constitution stat of the character, as an integer.
     */
    public void setConstitution(int constitution){
        stats.put(StatName.Intelligence, constitution);
    }

    /**
     * Sets the wisdom stat of the character in the CharacterDataClass.
     * @param wisdom the wisdom stat of the character, as an integer.
     */
    public void setWisdom(int wisdom){
        stats.put(StatName.Wisdom, wisdom);
        System.out.println(wisdom);

    }

    /**
     * Sets the charisma stat of the character in the CharacterDataClass.
     * @param charisma the charisma stat of the character, as an integer.
     */
    public void setCharisma(int charisma){
        stats.put(StatName.Charisma, charisma);
    }

    /**
     * Sets the dexterity stat of the character in the CharacterDataClass.
     * @param dexterity the dexterity stat of the character, as an integer.
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
    public int getXp() {
        return xp;
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

    public ArrayList<ProficiencySkills> getProficiencySkills(){
        return this.proficiencySkills;
    }





}
