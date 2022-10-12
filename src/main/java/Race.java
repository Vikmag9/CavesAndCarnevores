import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class Race {
    private String name;
    private String description;
    private int speed;
    private List<String> languages;
    private List<String> traits;
    private List<String> proficiencies;
    private JSONObject raceContent;
    static private final FileManager fm = new FileManager();

    public Race(String raceName) throws IOException, ClassNotFoundException {
        this.name = raceName;
        this.raceContent = null;//getRaceContent(name);
        this.description = getDescription();
        this.speed = getSpeed();

    }

    public JSONObject getRaceContent(String jobName) throws IOException, ClassNotFoundException {
        JSONObject jsonRace = fm.readFile("races.json").getJSONObject(jobName);
        return jsonRace;
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

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
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
