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

    public JSONObject readFile(String resourceName) throws IOException, ClassNotFoundException {

        InputStream is = Class.forName("FileManager").getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
        JSONTokener tokener = new JSONTokener(is);
        JSONObject content = new JSONObject(tokener);

        // Convert JSON string to JSONObject
        return content;
    }


    public void saveMap(HashMap map, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(map);
            FileOutputStream fileOut = new FileOutputStream( filePath + ".json");
            mapper.writeValue(fileOut, map);
            fileOut.close();
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
