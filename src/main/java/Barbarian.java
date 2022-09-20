import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Barbarian implements Job{
    private int hitdie;
    private int level;
    private Map<String, List<String>> proficiencies;
    JSONObject jobFeatures;

    public Barbarian() throws IOException, ClassNotFoundException {
        this.jobFeatures = getJob();
        this.hitdie = getHitDie();
        this.proficiencies = getProficiencies();
    }



    FileManager fm = new FileManager();
    public JSONObject getJob() throws IOException, ClassNotFoundException {
        JSONObject jsonJob = fm.readFile("jobs.json").getJSONObject("Barbarian");
        Map<String, Object> jobMap = jsonJob.toMap();
        return jsonJob;
    }


    public int getHitDie(){
        return jobFeatures.getJSONObject("Class Features").getInt("Hit Die");
    }

    public Map getProficiencies() {
        jobFeatures.getJSONObject("Class Features").getJSONObject("Proficiencies");
        return jobFeatures.getJSONObject("Class Features").getJSONObject("Proficiencies").toMap();
    }
    public List getEquipment() {
        return jobFeatures.getJSONObject("Class Features").getJSONObject("Equipment").getJSONArray("content").toList();
    }
}
