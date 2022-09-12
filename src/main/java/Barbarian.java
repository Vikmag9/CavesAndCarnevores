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
        if (jsonJob.toMap().containsKey("Barbarian"))
        {
            // TODO map json file into a Map only containing barbarian relevant information
        }
        return null;
    }
}
