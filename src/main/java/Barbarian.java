import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Barbarian implements Job{

    HashMap jobFeatures;

    public Barbarian() throws IOException {
        this.jobFeatures = getJob();
    }
    FileManager fm = new FileManager();
    public HashMap getJob() throws IOException {
        JSONObject jsonJob = fm.readFile(new File("")); // TODO Insert path to job JSON file
        Map jobMap = jsonJob.toMap();
        if (jobMap.containsKey("Barbarian")) {
            jobMap.get("Barbarian"); // Cannot be tested atm since application does not run. Need to run to figure out how to get barb information
            // TODO map json file into a Map only containing barbarian relevant information
        }
        return null;
    }
}
