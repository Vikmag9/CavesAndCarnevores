import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CharacterHandler {
    // TODO: Create a character object with data class as parameter and return it

    FileManager fm = new FileManager();
    public static Character createCharacter(CharacterDataCollection character, int level) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        return new Character(character, level);
    }

    public static void saveCharacter(Character character) {
        HashMap characterData = new HashMap<>();
        characterData.put("Name", character.getName());
        characterData.put("Level", String.valueOf(character.getLevel()));
        characterData.put("Race", character.getRaceName());
        characterData.put("Job", character.getJobName());
        characterData.put("Background", character.getBackground());
        characterData.put("xp", String.valueOf(character.getXp()));
        characterData.put("Gold", String.valueOf(character.getInventory().getCoinBag().getGoldCoin()));
        characterData.put("Inventory", character.getInventory().getInventory());
        characterData.put("Stats", character.getStats());
        characterData.put("AC", String.valueOf(character.getArmorClass()));
        characterData.put("Alignment", character.getAlignment());

        FileManager fm = new FileManager();
        fm.saveMap(characterData, "src/main/resources/characters/" + character.getName());

        //TODO parse into format for saving, delegate to FileManager by sending as hashmap
    }

    public static List<String> loadAllCharacters(){
        List<String> listOfCharacters = new ArrayList<>();
        File[] characters = new File("src/main/resources/characters/").listFiles();

        for (File character : characters) {
            listOfCharacters.add(FilenameUtils.removeExtension(character.getName()));
            //loadCharacter(); does not exist yet
        }
        return listOfCharacters;
    }
}
