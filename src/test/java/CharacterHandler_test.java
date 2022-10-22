import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CharacterHandler_test{

    @Test
    public void Run(){
        System.out.println(getFilesInDirectory("src/main/resources/characters/"));
    }

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

