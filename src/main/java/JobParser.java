import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class parses the Json file job.json and is used by the job class.
 * It contains the methods to retrieve the information from the Json file.
 * This is to avoid the job class from being directly dependent on the Json file.
 */
public class JobParser {
    private String jobName;
    private int hitdie;
    private Map proficiencies;
    private List<Feature> features;
    private JSONObject jobContent;
    static private final FileManager fm = new FileManager();

    /**
     * The constructor for the JobParser class.
     * @param jobName The name of the job, as a string.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public JobParser(String jobName) throws IOException, ClassNotFoundException {
        this.jobName = jobName;
        this.jobContent = getJob(jobName);
        this.features = parseFeatures();
        this.hitdie = getHitDie();
        this.proficiencies = parseProficiencies();
    }



    /**
     * A method to retrieve the information from the Json file.
     * @param jobName The name of the job, as a string.
     * @return The information from the Json file, as a JSONObject.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public JSONObject getJob(String jobName) throws IOException, ClassNotFoundException {
        JSONObject jsonJob = fm.readFile("jobs.json").getJSONObject(jobName);
        return jsonJob;
    }

    /**
     * a method to retrieve the features of a class from the Json file.
     * @return A list of features, as a list of Feature objects.
     */
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

    /**
     * A method to retrieve all the job names from the Json file.
     * @return A list of job names, as a list of strings.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<String> getAllJobs() throws IOException, ClassNotFoundException {
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

    /**
     * A method to retrieve and parse the proficiencies of a class from the Json file.
     * @return A map of proficiencies, as a map of strings and lists of strings.
     */
    public Map parseProficiencies() {
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

    public int getHitdie() {
        return hitdie;
    }

    public Map getProficiencies() {
        return proficiencies;
    }

}