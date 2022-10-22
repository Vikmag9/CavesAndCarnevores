package Model;

import FileManager.FileManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class RaceParser {
    private final String name;
    private JSONObject raceContent;
    static private final FileManager fm = new FileManager();

    public RaceParser(String raceName) {
        this.name = raceName;
        this.raceContent = RaceContent(name);
    }

    public RaceParser(String superRaceName,String subraceName) {
        this.name = subraceName;
        if (SubraceContent(superRaceName,subraceName) != null) {
            this.raceContent = SubraceContent(superRaceName, subraceName);
        } else {
            this.raceContent = null;
        }
    }

    public JSONObject RaceContent(String jobName) {
        JSONObject jsonRace = fm.readFile("races.json").getJSONObject(jobName);
        return jsonRace;
    }

    public JSONObject SubraceContent(String superRace, String subRace) {
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

    public static List<String> getAllRaces(){
        JSONObject races = fm.readFile("races.json");
        List<String> raceNames = new ArrayList<>();
        races.keySet().forEach(raceName -> {
            raceNames.add(raceName);
        });
        return raceNames;
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

    //--------------------------------- GETTERS AND SETTERS -------------------------------------
    public String getName() {
        return name;
    }









}
