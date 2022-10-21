import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * This class is named job, and represents what is called a class in dnd (5e) since class is a reserved word in java.
 * It contains all the information about a characters class, and is used to create a character.
 * It uses the JobParser class to retrieve the information from the jobs.json file.
 */
public class Job {
    private final String jobName;
    private final int hitdie;
    private Map proficiencies;
    private List<Feature> features;
    private String jobDescription;
    private JobParser jobParser;

    public Job(String jobName) {
        this.jobName = jobName;
        this.jobDescription = jobParser.getJobDesc();
        this.features = jobParser.parseFeatures();
        this.hitdie = jobParser.getHitDie();
        this.proficiencies = jobParser.parseProficiencies();
    }


    /**
     * This metod is used to get a list of all the available jobs.
     * Used in the GUI to display all the jobs.
     * @return a list of all the available jobs.
     */
    public static List<String> getAllJobs(){
        List<String> jobs = new ArrayList<>();
        List<String> jobNames = JobParser.getAllJobs();
        for (String jobName : jobNames) {
            jobs.add(jobName);
        }


    public int getHitDie() {
        return this.hitdie;
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

    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * This method is used to set the proficiencies a character has within the job class.
     * @param proficiencies a map of all the proficiencies a character has.
     */
    public void setProficiencies(Map proficiencies) {
        this.proficiencies = proficiencies;
    }

    /**
     * This method is used to set the features a character has within the job class.
     * @param features a list of all the features a character has.
     */
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public int getHitdie() {
        return hitdie;
    }

    public Map getProficiencies() {
        return proficiencies;
    }

}
