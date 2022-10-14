import java.io.File;

public class CharacterHandler {
    // TODO: Create a character object with data class as parameter and return it

    FileManager fm = new FileManager();
    public static Character createCharacter(Character character, int level) { //TODO make Character type into data class type
        return new Character(character, level);
    }

    public void saveCharacter(Character character) {
        //TODO parse into format for saving, delegate to FileManager by sending as hashmap
    }
}
