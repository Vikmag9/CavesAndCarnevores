package FileManager;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FileManager {


    public FileManager(){
    }

    public JSONObject readFile(String resourceName) {

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(resourceName);
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

    /**
     * Creates a String list of the names of the files in a certain directory based on a path.
     * @param dirPath the directory of the folder
     * @return a String List of the file names in the folder
     */
    public List<String> getFilesInDirectory(String dirPath) {
        File folder = new File(dirPath);
        File[] listOfFiles = folder.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileNames.add(FilenameUtils.removeExtension(file.getName()));
            }
        }
        return fileNames;
    }

}
