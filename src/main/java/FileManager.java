import org.json.*;
import org.apache.commons.io.*;
import java.io.File;
import java.io.IOException;

public class FileManager {

    public InventoryItem inventoryItem = new InventoryItem("", "", "", 0, 0, 0.0);

    public FileManager(){
    }
    public JSONObject readFile(File file) throws IOException {

        String content = "";
        if (file.isFile()) {
            content = FileUtils.readFileToString(file, "utf-8");
        }
        // Convert JSON string to JSONObject
        return new JSONObject(content);
    }


}
