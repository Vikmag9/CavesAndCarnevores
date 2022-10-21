import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class Job {
    private final String jobName;
    private final int hitdie;
    private Map proficiencies;
    private List<Feature> features;
    private JSONObject jobContent;
    static private final FileManager fm = new FileManager();

    public Job(String jobName) {
        this.jobName = jobName;
        this.jobContent = getJob(jobName);
        this.features = parseFeatures();
        this.hitdie = getHitDie();
        this.proficiencies = parseProficiencies();
    }



    public JSONObject getJob(String jobName) {
        JSONObject jsonJob = fm.readFile("jobs.json").getJSONObject(jobName);
        return jsonJob;
    }
    public List<Feature> parseFeatures() {
        ArrayList<Feature> features = new ArrayList<>();
        JSONObject featureTable = jobContent.getJSONObject("Class Features").getJSONObject("The "+this.jobName).getJSONObject("table");
        JSONArray featureNames = featureTable.getJSONArray("Features");
        JSONArray featureDescs = new JSONArray();
        featureNames.forEach(featureName -> {
            featureDescs.put(jobContent.getJSONObject("Class Features").getString(featureName.toString()));
        });
        JSONArray featurePreReqs = featureTable.getJSONArray("Level");
        for (int i = 0; i < featureNames.length(); i++) {
            features.add(new Feature(featureNames.getString(i), featureDescs.getString(i), featurePreReqs.getInt(i)));
        }
        return features;
    }

    public static List<String> getAllJobs() { // TODO: To be used when displaying all available jobs in the UI
        JSONObject jobs = fm.readFile("jobs.json");
        List<String> jobNames = new ArrayList<>();
        jobs.keySet().forEach(jobName -> {
            jobNames.add(jobName);
        });
        return jobNames;
    }

    public List<Feature> getFeatures() {
        return this.features;
    }


    public int getHitDie(){
        JSONObject classFeats = jobContent.getJSONObject("Class Features");
        int hitDie = classFeats.getInt("Hit Die");
        return hitDie;
    }

    public Map parseProficiencies() {
        jobContent.getJSONObject("Class Features").getJSONObject("Proficiencies");
        Map jsonMap = jobContent.getJSONObject("Class Features").getJSONObject("Proficiencies").toMap();
        Map profs = new HashMap();
        profs.put(Proficiencies.Armor, jsonMap.get("Armor"));
        profs.put(Proficiencies.Weapons, jsonMap.get("Weapons"));
        profs.put(Proficiencies.Tools, jsonMap.get("Tools"));
        profs.put(Proficiencies.SavingThrows, jsonMap.get("Saving Throws"));
        profs.put(Proficiencies.Skills, jsonMap.get("Skills"));
        return profs;
    }

    public String getJobDesc() {
        return jobContent.getJSONObject("Class Features").getString("content");
    }

    public String getJobName() {
        return jobName;
    }

    public List getEquipment() {
        return jobContent.getJSONObject("Class Features").getJSONObject("Equipment").getJSONArray("content").toList();
    }

    public void setProficiencies(Map proficiencies) {
        this.proficiencies = proficiencies;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public void setJobContent(JSONObject jobContent) {
        this.jobContent = jobContent;
    }

    public int getHitdie() {
        return hitdie;
    }

    public Map getProficiencies() {
        return proficiencies;
    }
}
