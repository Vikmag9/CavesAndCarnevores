import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class Job {
    private final String jobName;
    private final int hitdie;


    private int level;
    private Map proficiencies;
    private List<Feature> features;
    private JSONObject jobContent;

    FileManager fm = new FileManager();


    public Job(String jobName) throws IOException, ClassNotFoundException {
        this.jobName = jobName;
        this.jobContent = getJob(jobName);
        this.features = parseFeatures();
        this.hitdie = getHitDie();
        this.proficiencies = getProficiencies();
    }



    public JSONObject getJob(String jobName) throws IOException, ClassNotFoundException {
        JSONObject jsonJob = fm.readFile("jobs.json").getJSONObject(jobName);
        return jsonJob;
    }

    public List<Feature> parseFeatures() {
        List<Feature> features = emptyList();
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

    public List<Feature> getFeatures() {
        return this.features;
    }


    public int getHitDie(){
        return jobContent.getJSONObject("Class Features").getInt("Hit Die");
    }

    public Map getProficiencies() {
        jobContent.getJSONObject("Class Features").getJSONObject("Proficiencies");
        return jobContent.getJSONObject("Class Features").getJSONObject("Proficiencies").toMap();
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

    public int getLevel() {
        return level;
    }
}
