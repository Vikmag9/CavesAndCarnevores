import Items.InventoryItem;

import java.io.*;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;


public class FileManager {


    public FileManager(){
    }


    public void dosomething(String hej2, int hej){
        System.out.println(hej + hej2);
    }
    public void dosomething(int hej1, String hej2){
        System.out.println(hej1);
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


}
