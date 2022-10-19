import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Job {
    private final String jobName;
    private final int hitdie;
    private Map proficiencies;
    private List<Feature> features;
    private JSONObject jobContent;
    static private final FileManager fm = new FileManager();
    JobParser jobParser;

    public Job(String jobName) throws IOException, ClassNotFoundException {
        this.jobName = jobName;
        this.jobContent = jobParser.getJob(jobName);
        this.features = jobParser.parseFeatures();
        this.hitdie = jobParser.getHitDie();
        this.proficiencies = jobParser.parseProficiencies();
    }


    public static List<String> getAllJobs(){
        List<String> jobs = new ArrayList<>();
        try {
            List<String> jobNames = JobParser.getAllJobs();
            for (String jobName : jobNames) {
                jobs.add(jobName);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public int getHitDie() {
        return this.hitdie;
    }

    public List<Feature> getFeatures() {
        return this.features;
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
