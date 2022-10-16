import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CharacterHandler {
    // TODO: Create a character object with data class as parameter and return it

    FileManager fm = new FileManager();
    public static Character createCharacter(CharacterDataCollection character, int level) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        return new Character(character, level);
    }

    public void saveCharacter(Character character) {;
        HashMap characterData = new HashMap<>();
        characterData.put("Name", character.getName());
        characterData.put("Level", String.valueOf(character.getLevel()));
        characterData.put("Race", character.getRaceName());
        characterData.put("Job", character.getJobName());
        characterData.put("Background", character.getBackground());
        characterData.put("xp", String.valueOf(character.getXp()));
        characterData.put("Gold", String.valueOf(character.getInventory().getCoinBag().getCoins()));

        //TODO parse into format for saving, delegate to FileManager by sending as hashmap
    }
}
