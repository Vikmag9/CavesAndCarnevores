
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
     * @param raceParsed The parsed information from the race JSON file.
     */
    public Race(RaceParser raceParsed) {
        this.name = raceParsed.getName();
        this.description = raceParsed.getDescription();
        this.speed = raceParsed.getSpeed();
        this.traits = raceParsed.getTraits();
        this.proficiencies = raceParsed.getProficiencies();
    }

    public Race(String raceName) {
        this.name = raceName;
        this.raceContent = getRaceContent(name);
        this.description = parseDescription();
        this.speed = parseSpeed();
        this.traits = parseTraits();
        this.proficiencies = parseProficiencies();
    /**
     * One of the 3 constructors for the Race class.
     * Uses the input parameter to then retrieve the data from the raceParser class.
     * @param racename The name of a characters race, as a string.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Race(String racename) throws IOException, ClassNotFoundException {
        RaceParser raceParser = new RaceParser(racename);
        this.name = raceParser.getName();
        this.description = raceParser.getDescription();
        this.speed = raceParser.getSpeed();
        this.traits = raceParser.getTraits();
        this.proficiencies = raceParser.getProficiencies();
    }

    public Race(String superRaceName,String subraceName) {
        this.name = subraceName;
        if (getSubraceContent(superRaceName,subraceName) != null) {
            this.raceContent = getSubraceContent(superRaceName, subraceName);
            this.description = parseDescription();
            this.speed = parseSpeed();
            this.traits = parseTraits();
            this.proficiencies = parseProficiencies();
        }
    }

    public JSONObject getRaceContent(String raceName) {
        JSONObject jsonRace = fm.readFile("races.json").getJSONObject(raceName);
        return jsonRace;
    }

    public JSONObject getSubraceContent(String superRace, String subRace) {
        JSONArray jsonRace = fm.readFile("races.json").getJSONObject(superRace).getJSONArray("Subraces");
        AtomicReference<JSONObject> subRaceContent = null;
        JSONObject subRaceContent1 = null;
        for (int i = 0; i < jsonRace.length(); i++) {
            if (jsonRace.getJSONObject(i).toMap().containsKey(subRace)) {
                return jsonRace.getJSONObject(i).getJSONObject(subRace);
            }
        }
        return null;
    }

    public static List<String> getAllRaces() {
        JSONObject races = fm.readFile("races.json");
        List<String> raceNames = new ArrayList<>();
        races.keySet().forEach(raceName -> {
            raceNames.add(raceName);
        });
        return raceNames;
    /**
     * One of the 3 constructors for the Race Class.
     * Used when setting a race with a subrace.
     * Uses the input parameter to then retrieve the data from the raceParser class, that belongs to the race and subrace.
     * @param superRaceName The name of the race of the character, as a string.
     * @param subraceName The name of the subrace of the character, as a string.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Race(String superRaceName,String subraceName) throws IOException, ClassNotFoundException {
        RaceParser raceParser = new RaceParser(superRaceName,subraceName);
        this.name = raceParser.getName();
        this.description = raceParser.getDescription();
        this.speed = raceParser.getSpeed();
        this.traits = raceParser.getTraits();
        this.proficiencies = raceParser.getProficiencies();
    }

    public static List<Race> getAllSubraces(String superRace) {
        JSONObject races = fm.readFile("races.json");
        List<Race> SubraceNames = new ArrayList<>();
        JSONArray w = races.getJSONObject(superRace).getJSONArray("Subraces");
        JSONObject x = w.getJSONObject(1);
        for (int i = 0; i < w.length(); i++) {
            String subName = w.getJSONObject(i).keySet().toString().replace("[","").replace("]","");
            SubraceNames.add(new Race(superRace, subName));
        }
        w.getJSONObject(0).keySet().forEach(subRaceName -> {
            SubraceNames.add(new Race(superRace,subRaceName));

        });
        return SubraceNames;
    }



    public List<Feature> parseTraits() {
        ArrayList<Feature> traits = new ArrayList<>();
        JSONArray featureNames = raceContent.getJSONArray("Traits");
        featureNames.forEach(featureName -> {
            traits.add(new Feature(featureName.toString(), "", 1));
        });
        return traits;
    }

    public String parseDescription(){
        return raceContent.getString("Description");
    }

    public Map parseProficiencies(){

        Map jsonMap = raceContent.getJSONObject("Proficiencies").toMap();
        HashMap profs = new HashMap();
        profs.put(Proficiencies.Armor, jsonMap.get("Armor"));
        profs.put(Proficiencies.Weapons, jsonMap.get("Weapons"));
        profs.put(Proficiencies.Tools, jsonMap.get("Tools"));
        profs.put(Proficiencies.SavingThrows, jsonMap.get("Saving Throws"));
        profs.put(Proficiencies.Skills, jsonMap.get("Skills"));
        return profs;
    }
    public Map<String, String> parseAbilityScores(){
        JSONArray absScores = raceContent.getJSONArray("Ability score increase");
        return Map.of("Strength", String.valueOf(absScores.getInt(0)), "Dexterity", String.valueOf(absScores.getInt(1)), "Constitution", String.valueOf(absScores.getInt(2)), "Intelligence", String.valueOf(absScores.getInt(3)), "Wisdom", String.valueOf(absScores.getInt(4)), "Charisma", String.valueOf(absScores.getInt(5)));
    }

    public int parseSpeed(){
        return raceContent.getInt("Speed");
    }

    public void setupSubrace(Race subRace) {
        setSubRace(subRace);
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
        RaceParser.getAllSubraces(raceName).forEach(subrace -> {
            subraces.add(new Race(subrace.getName()));
        });
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
        List<String> racenames = null;
        racenames = RaceParser.getAllRaces();

        return racenames;
    }




    public String getSubraceName() {
        return this.subRace.getName();
    }



}
