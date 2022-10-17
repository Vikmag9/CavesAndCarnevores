package Model;

import java.io.IOException;
import java.util.HashMap;

import Model.Character;
import Model.CharacterDataCollection;

public class CharacterHandler {
    // TODO: Create a character object with data class as parameter and return it

    FileManager fm = new FileManager();
    public static Character createCharacter(CharacterDataCollection character, int level) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        return new Character(character, level);
    }

    public static void saveCharacter(Character character) {;
        HashMap characterData = new HashMap<>();
        characterData.put("Name", character.getName());
        characterData.put("Level", String.valueOf(character.getLevel()));
        characterData.put("Model.Race", character.getRaceName());
        characterData.put("Model.Job", character.getJobName());
        characterData.put("Background", character.getBackground());
        characterData.put("xp", String.valueOf(character.getXp()));
        characterData.put("Gold", String.valueOf(character.getInventory().getCoinBag().getGoldCoin()));
        characterData.put("Inventory", character.getInventory().getInventory());
        characterData.put("Stats", character.getStats());
        characterData.put("AC", String.valueOf(character.getArmorClass()));
        characterData.put("Alignment", character.getAlignment());

        FileManager fm = new FileManager();
        fm.saveMap(characterData, "src/main/resources/characters/" + character.getName());

        //TODO parse into format for saving, delegate to Model.FileManager by sending as hashmap
    }
}
