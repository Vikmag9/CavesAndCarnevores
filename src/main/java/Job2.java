import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Job2 {
    private final String jobName;
    private final int hitdie;
    private int level;
    private Map proficiencies;
    JSONObject jobFeatures;

    FileManager fm = new FileManager();


    public Job2(String jobName) throws IOException, ClassNotFoundException {
        this.jobName = jobName;
        this.jobFeatures = getJob(jobName);
        this.hitdie = getHitDie();
        this.proficiencies = getProficiencies();
    }



    public JSONObject getJob(String jobName) throws IOException, ClassNotFoundException {
        JSONObject jsonJob = fm.readFile("jobs.json").getJSONObject(jobName);
        return jsonJob;
    }


    public int getHitDie(){
        return jobFeatures.getJSONObject("Class Features").getInt("Hit Die");
    }

    public Map getProficiencies() {
        jobFeatures.getJSONObject("Class Features").getJSONObject("Proficiencies");
        return jobFeatures.getJSONObject("Class Features").getJSONObject("Proficiencies").toMap();
    }

    public String getJobDesc() {
        return jobFeatures.getJSONObject("Class Features").getString("content");
    }

    public String getJobName() {
        return jobName;
    }

    public List getEquipment() {
        return jobFeatures.getJSONObject("Class Features").getJSONObject("Equipment").getJSONArray("content").toList();
    }
}
