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

    public static void saveCharacter(Character character) {
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
        characterData.put("SkillProficiencies", character.getProficiencySkills());

        fm.saveMap(characterData, "src/main/resources/characters/" + character.getName());

    }

    /**
     *  Gets all the relevant character data from a json file to a Map and loads it into a character object. Among other things, it is used by loadAllCharacters() to produce a
     *  list of characterObjects for populating the CharacterScreen later.
     * @param name A string with the name of a character
     * @return A characterObject
     */
    public static Character loadCharacter(String name) {

        Map<String, Object> characterData = fm.readFile("characters/" + name + ".json").toMap();
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

        /*
        List<Proficiencies> skillProfs = new ArrayList();
        List<String> skillProfsString = (List<String>) characterData.get("SkillProficiencies");
        skillProfsString.forEach(skill -> {
            String x = skill;
            skillProfs.add(Proficiencies.valueOf(skill));
        });*/

        Character characterObject = new Character(character, character.getLevel());
        String subRace = characterData.get("Subrace").toString();
        if (!subRace.equals("None")) {
            characterObject.getRace().setSubRace(new Race(character.getRaceName(), subRace));
        }


        return characterObject;
    }

    /**
     * Gets the names of all files within the Characters folder and calls on loadCharacter() for each of them. Then adds
     * the return value of loadCharacter() to a list of character objects.
     * @return A list of character objects
     */
    public static ArrayList<Character> loadAllCharacters(){
        ArrayList<Character> listOfCharacters = new ArrayList<>();
        ArrayList<String> characterNames = new ArrayList<>(fm.getFilesInDirectory("src/main/resources/characters/"));
        characterNames.forEach(name -> listOfCharacters.add(loadCharacter(name)));
        return listOfCharacters;
    }

}
