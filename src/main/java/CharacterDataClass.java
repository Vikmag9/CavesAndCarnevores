import Items.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

/*
This class has taken inspiration from the builder pattern. It behaves like a builder, but the builder pattern is not used.
However, it can in the future, which makes it extendable.
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

    CharacterDataClass(){
        this.stats = new HashMap<StatName, Integer>();
        this.proficiencySkills = new ArrayList<>();

    }

    public CharacterDataClass setName(String name){
        this.name = name;
        return this;
    }

    public CharacterDataClass setJobName(String jobName){
        this.jobName = jobName;
        return this;
    }

    public CharacterDataClass setRaceName(String raceName){
        this.raceName = raceName;
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

    public CharacterDataClass setStats(HashMap<StatName, Integer> stats){
        this.stats = stats;
        return this;
    }

    public CharacterDataClass setAlignment(String alignment){
        this.alignment = alignment;
        return this;
    }

    public CharacterDataClass setLanguages(String languages){
        this.languages = languages;
        return this;
    }

    public CharacterDataClass setEarlierLife(String earlierLife){
        this.earlierLife = earlierLife;
        return this;
    }

    public CharacterDataClass setCoreMemories(String coreMemories){
        this.coreMemories = coreMemories;
        return this;
    }

    public CharacterDataClass setOrganisations(String organisations){
        this.organisations = organisations;
        return this;
    }

    public void setStrength(int strength){
        stats.put(StatName.Strength, strength);
        System.out.println(strength);
    }

    public void setIntelligence(int intelligence){
        stats.put(StatName.Intelligence, intelligence);
        System.out.println(intelligence);

    }

    public void setConstitution(int constitution){
        stats.put(StatName.Intelligence, constitution);
    }

    public void setWisdom(int wisdom){
        stats.put(StatName.Wisdom, wisdom);
        System.out.println(wisdom);

    }

    public void setCharisma(int charisma){
        stats.put(StatName.Charisma, charisma);
    }

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

}
