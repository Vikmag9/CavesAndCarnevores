import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Job {

    public JSONObject getJob() throws IOException, ClassNotFoundException;
    public int getHitDie();
    public List getEquipment();
    public Map getProficiencies();
    public String getJobDesc();
    public String getJobName();



}
