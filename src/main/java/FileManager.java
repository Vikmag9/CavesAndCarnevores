import Items.InventoryItem;

import java.io.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.HashMap;


public class FileManager {


    public FileManager(){
    }

    public JSONObject readFile(String resourceName) {

        try {
            InputStream is = Class.forName("FileManager").getResourceAsStream(resourceName);
            if (is == null) {
                throw new NullPointerException("Cannot find resource file " + resourceName);
            }
            JSONTokener tokener = new JSONTokener(is);
            JSONObject content = new JSONObject(tokener);
            return content;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
    }


    public void saveMap(HashMap map, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(map);
            FileOutputStream fileOut = new FileOutputStream( filePath + ".json");
            mapper.writeValue(fileOut, map);
            fileOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
