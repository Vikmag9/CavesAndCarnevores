package Model;

import FileManager.FileManager;
import Model.Items.Inventory;
import Model.Items.InventoryItem;
import Model.Items.InventoryItemBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterHandler {
    private static FileManager fm = new FileManager();

    public static Character createCharacter(CharacterDataCollection character, int level) {
        return new Character(character, level);
    }

    public static void saveCharacter(Character character) {;
        HashMap<Object, Object> characterData = new HashMap<>();
        characterData.put("Name", character.getName());
        characterData.put("Level", String.valueOf(character.getLevel()));
        characterData.put("Race", character.getRaceName());
        characterData.put("Job", character.getJobName());
        characterData.put("Background", character.getBackground());
        characterData.put("xp", String.valueOf(character.getXp()));
        characterData.put("Gold", String.valueOf(character.getInventory().getCoinBag().getCoin()));
        characterData.put("Inventory", character.getInventory().getInventory());
        characterData.put("Model", character.getStats());
        characterData.put("AC", String.valueOf(character.getArmorClass()));
        characterData.put("HP", String.valueOf(character.getHealth()));
        characterData.put("Alignment", character.getAlignment());
        if (character.getRace().getSubRace() != null) {
            characterData.put("Subrace", character.getRace().getSubraceName());
        }
        else {
            characterData.put("Subrace", "None");
        }
        characterData.put("Proficiencies", character.getJob().getProficiencies());

        fm.saveMap(characterData, "src/main/resources/characters/" + character.getName());

    }

    public static Character loadCharacter(String name) {

        Map characterData = fm.readFile("characters/" + name + ".json").toMap();
        CharacterDataClass character = new CharacterDataClass();
        character.setName((String) characterData.get("Name"));
        character.setLevel(Integer.parseInt((String) characterData.get("Level")));
        character.setRaceName((String) characterData.get("Race"));
        character.setJobName((String) characterData.get("Job"));
        character.setBackground((String) characterData.get("Background"));
        character.setXp(Integer.parseInt((String) characterData.get("xp")));


        Inventory inventory = new Inventory(0);
        List<Map> inventoryItemListLoaded = (List<Map>) characterData.get("Inventory");
        List<InventoryItem> inventoryItemListParsed = new ArrayList();
        inventoryItemListLoaded.forEach(item -> {
            InventoryItemBuilder builder = new InventoryItemBuilder(item.get("itemType").toString(), item.get("itemName").toString(), item.get("itemDescription").toString(),Integer.parseInt(item.get("itemValue").toString()), Double.parseDouble(item.get("itemWeight").toString()), Boolean.parseBoolean(item.get("isMagical").toString()));
            inventoryItemListParsed.add(new InventoryItem(builder));
        });

        inventory.setInventory(inventoryItemListParsed);
        character.setInventory(inventory);


        character.getInventory().getCoinBag().setCoins(Integer.parseInt((String) characterData.get("Gold")));
        character.getInventory().setInventory(inventoryItemListParsed);

        HashMap<String, Integer> stats = (HashMap<String, Integer>) characterData.get("Model");
        HashMap<StatName, Integer> enumStat = new HashMap<>();
        enumStat.put(StatName.Strength, stats.get("Strength"));
        enumStat.put(StatName.Dexterity, stats.get("Dexterity"));
        enumStat.put(StatName.Constitution, stats.get("Constitution"));
        enumStat.put(StatName.Intelligence, stats.get("Intelligence"));
        enumStat.put(StatName.Wisdom, stats.get("Wisdom"));
        enumStat.put(StatName.Charisma, stats.get("Charisma"));
        character.setStats(enumStat);

        Character characterObject = new Character(character, character.getLevel());
        String subRace = characterData.get("Subrace").toString();
        if (!subRace.equals("None")) {
            characterObject.getRace().setSubRace(new Race(character.getRaceName(), subRace));
        }
        return characterObject;
    }




 /*   public static List<String> loadAllCharacters(){
        List<String> listOfCharacters = new ArrayList<>();
        File[] characters = new File("src/main/resources/characters/").listFiles();
        if (characters != null) {
            //loadCharacter(); does not exist yet
            for (File character : characters) listOfCharacters.add(FilenameUtils.removeExtension(character.getName()));
        }
        return listOfCharacters;
    }

  */
}
