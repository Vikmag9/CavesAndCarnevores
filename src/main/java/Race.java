
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Race {
    private String name;
    private String description;
    private int speed;
    private List<Feature> traits;
    private Map proficiencies;
    private Race subRace;

    /**
     * One of the 3 constructors for the Race class.
     * Uses the input parameter to then retrieve the data from the raceParser class.
     * @param racename The name of a characters race, as a string.
     */
    public Race(String racename) {
        RaceParser raceParser = new RaceParser(racename);
        this.name = raceParser.getName();
        this.description = raceParser.parseDescription();
        this.speed = raceParser.parseSpeed();
        this.traits = raceParser.parseTraits();
        this.proficiencies = raceParser.parseProficiencies();
    }

    /**
     * One of the 3 constructors for the Race Class.
     * Used when setting a race with a subrace.
     * Uses the input parameter to then retrieve the data from the raceParser class, that belongs to the race and subrace.
     * @param superRaceName The name of the race of the character, as a string.
     * @param subraceName The name of the subrace of the character, as a string.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Race(String superRaceName,String subraceName) {
        RaceParser raceParser = new RaceParser(superRaceName, subraceName);
        this.name = raceParser.getName();
        this.description = raceParser.parseDescription();
        this.speed = raceParser.parseSpeed();
        this.traits = raceParser.parseTraits();
        this.proficiencies = raceParser.parseProficiencies();
    }


    //--------------------------------- GETTERS AND SETTERS -------------------------------------
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a characters race.
     * @param name the name of a characters race, as a string.
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the race description of a character.
     * @param description the description of the race, as a character
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Race getSubRace() {
        if (subRace != null) {
            return subRace;
        }
        return null;
    }

    public static List<Race> getAllSubraces(String raceName) {
        List<Race> subraces = new ArrayList<>();
        subraces = RaceParser.getAllSubraces(raceName);
        return subraces;
    }


    public void setSubRace(Race subrace){ // Use this when a subrace has been selected by the user from getAllSubraces()
        this.subRace = subrace;
        setSpeed(subrace.getSpeed());
    }

    public List<Feature> getTraits() {
        return traits;
    }

    public void setTraits(List<Feature> traits) {
        this.traits = traits;
    }

    public Map getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(Map<String, String> proficiencies) {this.proficiencies = proficiencies;}

    public static List<String> getAllRaces(){
        return RaceParser.getAllRaces();
    }

    public String getSubraceName() {
        return this.subRace.getName();
    }



}
