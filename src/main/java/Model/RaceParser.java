package Model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class RaceParser {
    private String name;
    private String description;
    private int speed;
    private List<Feature> traits;
    private Map proficiencies;
    private Race subRace;
    private JSONObject raceContent;
    static private final FileManager fm = new FileManager();

    public RaceParser(String raceName) throws IOException, ClassNotFoundException {
        this.name = raceName;
        this.raceContent = RaceContent(name);
        this.description = parseDescription();
        this.speed = parseSpeed();
        this.traits = parseTraits();
        this.proficiencies = parseProficiencies();
    }

    public RaceParser(String superRaceName,String subraceName) throws IOException, ClassNotFoundException {
        this.name = subraceName;
        if (SubraceContent(superRaceName,subraceName) != null) {
            this.raceContent = SubraceContent(superRaceName, subraceName);
            this.description = parseDescription();
            this.speed = parseSpeed();
            this.traits = parseTraits();
            this.proficiencies = parseProficiencies();
        }
    }

    public JSONObject RaceContent(String jobName) throws IOException, ClassNotFoundException {
        JSONObject jsonRace = fm.readFile("races.json").getJSONObject(jobName);
        return jsonRace;
    }

    public JSONObject SubraceContent(String superRace, String subRace) throws IOException, ClassNotFoundException {
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

    public static List<String> getAllRaces() throws IOException, ClassNotFoundException {
        JSONObject races = fm.readFile("races.json");
        List<String> raceNames = new ArrayList<>();
        races.keySet().forEach(raceName -> {
            raceNames.add(raceName);
        });
        return raceNames;
    }

    public static List<Race> getAllSubraces(String superRace) throws IOException, ClassNotFoundException {
        JSONObject races = fm.readFile("races.json");
        List<Race> SubraceNames = new ArrayList<>();
        JSONArray w = races.getJSONObject(superRace).getJSONArray("Subraces");
        JSONObject x = w.getJSONObject(1);
        for (int i = 0; i < w.length(); i++) {
            String subName = w.getJSONObject(i).keySet().toString().replace("[","").replace("]","");
            SubraceNames.add(new Race(superRace, subName));
        }
        w.getJSONObject(0).keySet().forEach(subRaceName -> {
            try {
                SubraceNames.add(new Race(superRace,subRaceName));
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
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
        return raceContent.getJSONObject("Proficiencies").toMap();
    }
    public Map<String, String> parseAbilityScores(){
        JSONArray absScores = raceContent.getJSONArray("Ability score increase");
        return Map.of("Strength", String.valueOf(absScores.getInt(0)), "Dexterity", String.valueOf(absScores.getInt(1)), "Constitution", String.valueOf(absScores.getInt(2)), "Intelligence", String.valueOf(absScores.getInt(3)), "Wisdom", String.valueOf(absScores.getInt(4)), "Charisma", String.valueOf(absScores.getInt(5)));
    }

    public int parseSpeed(){
        return raceContent.getInt("Speed");
    }
    public Race parseSubRace(){
        return null;
    }

    public void setupSubrace(Race subRace) {
        setSubRace(subRace);
    }

    //--------------------------------- GETTERS AND SETTERS -------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

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
        return this.subRace;
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





}
