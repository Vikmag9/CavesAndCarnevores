import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Race {
    private String name;
    private String description;
    private int speed;
    private List<String> traits;
    private List<String> proficiencies;
    private JSONObject raceContent;
    static private final FileManager fm = new FileManager();

    public Race(String raceName) throws IOException, ClassNotFoundException {
        this.name = raceName;
        this.raceContent = getRaceContent(name);
        this.description = getDescription();
        this.speed = getSpeed();

    }

    public JSONObject getRaceContent(String jobName) throws IOException, ClassNotFoundException {
        JSONObject jsonRace = fm.readFile("races.json").getJSONObject(jobName);
        return jsonRace;
    }

    public static List<String> getAllRaces() throws IOException, ClassNotFoundException {
        JSONObject races = fm.readFile("races.json");
        List<String> raceNames = new ArrayList<>();
        races.keySet().forEach(jobName -> {
            raceNames.add(jobName);
        });
        return raceNames;
    }

    public List<String> parseTraits() {
        ArrayList<String> traits = new ArrayList<>();
        JSONObject race = raceContent.getJSONObject(name);
        JSONArray featureNames = race.getJSONArray("Traits");
        featureNames.forEach(featureName -> {
            traits.add(featureName.toString());
        });
        return traits;
    }

    public String parseDescription(){
        JSONObject race = raceContent.getJSONObject(name);
        return race.getString("Description");
    }

    public Map parseProficiencies(){
        JSONObject race = raceContent.getJSONObject(name);
        return race.getJSONObject("Proficiencies").toMap();
    }
    public Map<String, String> parseAbilityScores(){
        JSONObject race = raceContent.getJSONObject(name);
        JSONArray absScores = race.getJSONArray("Ability score increase");
        return Map.of("Strength", String.valueOf(absScores.getInt(0)), "Dexterity", String.valueOf(absScores.getInt(1)), "Constitution", String.valueOf(absScores.getInt(2)), "Intelligence", String.valueOf(absScores.getInt(3)), "Wisdom", String.valueOf(absScores.getInt(4)), "Charisma", String.valueOf(absScores.getInt(5)));
    }
    public Race parseSubRace(){
        return null;
    }


    //--------------------------------- GETTERS AND SETTERS -------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return "description";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSpeed() {
        return 0;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public List<String> getTraits() {
        return traits;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    public List<String> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }







}
