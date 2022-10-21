import Items.Inventory;
import Items.InventoryItem;
import Items.InventoryItemBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Stats.Stats.*;

import static org.junit.Assert.*;


public class Character_test {
    /*
    @Test
    public void createBarbarianTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Barbarian");
        List<Feature> featureList = charJob.getFeatures();


        HashMap<String, InventoryItem> inventoryMap = new HashMap<String, InventoryItem>();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);

        Character character = new Character("Gregg", new Race("Batman"),
                charJob,
                inventory,
                1,
                "Orphan");


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getName(), "Batman");
        assertEquals(character.getJob().getJobName(), "Barbarian");
        assertEquals(character.getFeats(), featureList);
        assertEquals(character.getInventory(), inventory);
        assertEquals(character.getHealth(), 7);
        assertEquals(character.getArmorClass(), 12);

    }

    @Test
    public void createBardTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Bard");
        List<Feature> featureList = charJob.getFeatures();
        HashMap<String, InventoryItem> inventoryMap = new HashMap<String, InventoryItem>();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);

        Character character = new Character("Gregg", new Race("Batman"),
                charJob,
                inventory,
                1,
                "Orphan");


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getName(), "Batman");
        assertEquals(character.getJob().getJobName(), "Bard");
        assertEquals(character.getFeats(), featureList);
        assertEquals(character.getInventory(), inventory);
        assertEquals(character.getHealth(), 5);
        assertEquals(character.getArmorClass(), 12);

    }

    @Test
    public void createClericTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Cleric");
        List<Feature> featureList = charJob.getFeatures();
        HashMap<String, InventoryItem> inventoryMap = new HashMap<String, InventoryItem>();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);
        Character character = new Character("Gregg", new Race("Batman"),
                charJob,
                inventory,
                1,
                "Orphan");


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getName(), "Batman");
        assertEquals(character.getJob().getJobName(), "Cleric");
        assertEquals(character.getFeats(), featureList);
        assertEquals(character.getInventory(), inventory);
        assertEquals(character.getHealth(), 5);
        assertEquals(character.getArmorClass(), 12);
    }

    @Test
    public void createDruidTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Druid");
        List<Feature> featureList = charJob.getFeatures();
        HashMap<String, InventoryItem> inventoryMap = new HashMap<String, InventoryItem>();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);

        Character character = new Character("Gregg", new Race("Batman"),
                charJob,
                inventory,
                1,
                "Orphan");


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getName(), "Batman");
        assertEquals(character.getJob().getJobName(), "Druid");
        assertEquals(character.getFeats(), featureList);
        assertEquals(character.getInventory(), inventory);
        assertEquals(character.getHealth(), 5);
        assertEquals(character.getArmorClass(), 12);
    }

    @Test
    public void createFighterTest() throws IOException, ClassNotFoundException {
            Job charJob = new Job("Fighter");
            List<Feature> featureList = charJob.getFeatures();
            HashMap<String, InventoryItem> inventoryMap = new HashMap<String, InventoryItem>();
            Inventory inventory = new Inventory(1);
            InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
            builder.ac(12);
            builder.isequipped(true);
            InventoryItem cheeseArmor = new InventoryItem(builder);
            inventory.addItem(cheeseArmor);

            Character character = new Character("Gregg", new Race("Batman"),
                    charJob,
                    inventory,
                    1,
                    "Orphan");


            assertEquals(character.getName(), "Gregg");
            assertEquals(character.getRace().getName(), "Batman");
            assertEquals(character.getJob().getJobName(), "Fighter");
            assertEquals(character.getFeats(), featureList);
            assertEquals(character.getInventory(), inventory);
            assertEquals(character.getHealth(), 6);
            assertEquals(character.getArmorClass(), 12);
        }

    @Test
    public void createMonkTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Monk");
        List<Feature> featureList = charJob.getFeatures();
        HashMap<String, InventoryItem> inventoryMap = new HashMap<String, InventoryItem>();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);

        Character character = new Character("Gregg", new Race("Batman"),
                charJob,
                inventory,
                1,
                "Orphan");


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getName(), "Batman");
        assertEquals(character.getJob().getJobName(), "Monk");
        assertEquals(character.getFeats(), featureList);
        assertEquals(character.getInventory(), inventory);
        assertEquals(character.getHealth(), 5);
        assertEquals(character.getArmorClass(), 12);
    }

    @Test
    public void createPaladinTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Paladin");
        List<Feature> featureList = charJob.getFeatures();
        HashMap<String, InventoryItem> inventoryMap = new HashMap<String, InventoryItem>();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);
        Character character = new Character("Gregg", new Race("Batman"),
                charJob,
                inventory,
                1,
                "Orphan");


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getName(), "Batman");
        assertEquals(character.getJob().getJobName(), "Paladin");
        assertEquals(character.getFeats(), featureList);
        assertEquals(character.getInventory(), inventory);
        assertEquals(character.getHealth(), 6);
        assertEquals(character.getArmorClass(), 12);
    }

    @Test
    public void createRangerTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Ranger");
        List<Feature> featureList = charJob.getFeatures();
        HashMap<String, InventoryItem> inventoryMap = new HashMap<String, InventoryItem>();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);
        Character character = new Character("Gregg", new Race("Batman"),
                charJob,
                inventory,
                1,
                "Orphan");


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getName(), "Batman");
        assertEquals(character.getJob().getJobName(), "Ranger");
        assertEquals(character.getFeats(), featureList);
        assertEquals(character.getInventory(), inventory);
        assertEquals(character.getHealth(), 6);
        assertEquals(character.getArmorClass(), 12);
    }

    @Test
    public void createRougeTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Rogue");
        List<Feature> featureList = charJob.getFeatures();

        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);

        Character character = new Character("Gregg", new Race("Batman"),
                charJob,
                inventory,
                1,
                "Orphan");

        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getName(), "Batman");
        assertEquals(character.getJob().getJobName(), "Rogue");
        assertEquals(character.getFeats(), featureList);
        assertEquals(character.getInventory(), inventory);
        assertEquals(character.getHealth(), 5);
        assertEquals(character.getArmorClass(), 12);
    }

    @Test
    public void testBarbarianParsing() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Barbarian");
        Inventory inventory = new Inventory(1);
        Character BarbarianCharacter = new Character("Gregg", new Race("Human"),
                charJob,
                inventory,
                1,
                "Orphan");

        ArrayList<String> barbArmorProf = new ArrayList<>(); // Tests if the armor proficiencies are retrieved correctly
        barbArmorProf.add("Light armor");
        barbArmorProf.add("Medium armor");
        barbArmorProf.add("Shields");

        ArrayList<String> barbWeaponProf = new ArrayList<>(); // Tests if the weapon proficiencies are retrieved correctly
        barbWeaponProf.add("Simple weapons");
        barbWeaponProf.add("Martial weapons");

        ArrayList<String> barbToolsProf = new ArrayList<>(); // Tests if the tool proficiencies are retrieved correctly
        barbToolsProf.add("None");

        ArrayList<String> barbSavingProf = new ArrayList<>(); // Tests if the saving throw proficiencies are retrieved correctly
        barbSavingProf.add("Strength");
        barbSavingProf.add("Constitution");

        ArrayList<String> barbSkillOptions = new ArrayList<>(); // Tests if the skill proficiencies are retrieved correctly
        barbSkillOptions.add("Animal Handling");
        barbSkillOptions.add("Athletics");
        barbSkillOptions.add("Intimidation");
        barbSkillOptions.add("Nature");
        barbSkillOptions.add("Perception");
        barbSkillOptions.add("Survival");

        assertEquals(BarbarianCharacter.getJob().getHitDie(), 12); // Tests that the hit die is 12

        assertEquals(barbArmorProf, BarbarianCharacter.getJob().getProficiencies().get("Armor")); // Tests if the tool proficiencies are the retrieved correctly

        assertEquals(barbWeaponProf, BarbarianCharacter.getJob().getProficiencies().get("Weapons")); // Tests if the tool proficiencies are retrieved correctly

        assertEquals(barbToolsProf, BarbarianCharacter.getJob().getProficiencies().get("Tools")); // Tests if the tool proficiencies are retrieved correctly

        assertEquals(barbSavingProf, BarbarianCharacter.getJob().getProficiencies().get("Saving throws")); // Tests if the saving throw proficiencies are retrieved correctly

        assertEquals(barbSkillOptions, BarbarianCharacter.getJob().getProficiencies().get("SkillOptions")); // Tests if the skill proficiencies are retrieved correctly

        // TODO add equal tests for other jobs
    }

     */

    @Test
    public void createRaceTest() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        Job charJob = new Job("Rogue");
        List<Feature> featureList = charJob.getFeatures();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);

        CharacterDataClass charData = new CharacterDataClass();
        charData.setBackground("Orphan");
        charData.setRaceName("Dwarf");
        charData.setJobName("Rogue");
        charData.setName("Gregg");
        charData.setLevel(1);
        charData.setInventory(inventory);

        HashMap<StatName, Integer> charStats  = new HashMap<StatName, Integer>();
        charStats.put(StatName.Strength, 10);
        charStats.put(StatName.Dexterity, 10);
        charStats.put(StatName.Constitution, 12);
        charStats.put(StatName.Intelligence, 10);
        charStats.put(StatName.Wisdom, 10);
        charStats.put(StatName.Charisma, 10);

        charData.setStats(charStats);

        Character character = new Character(charData, charData.getLevel());

        character.getRace().setSubRace(Race.getAllSubraces("Dwarf").get(1));

        assertEquals(character.getRace().getName(), "Dwarf");
        assertEquals(character.getRace().getSpeed(), 25);
        assertEquals(character.getRace().getSubRace().getName(), "Mountain Dwarf");
        assertEquals(character.getHealth(), 5); // Tests that the hit die is 12



    }

    @Test
    public void calculateHpTest() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        Job charJob = new Job("Rogue");
        List<Feature> featureList = charJob.getFeatures();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);

        CharacterDataClass charData = new CharacterDataClass();
        charData.setBackground("Orphan");
        charData.setRaceName("Dwarf");
        charData.setJobName("Rogue");
        charData.setName("Gregg");
        charData.setLevel(1);
        charData.setInventory(inventory);

        HashMap<StatName, Integer> charStats  = new HashMap<>();
        charStats.put(StatName.Strength, 10);
        charStats.put(StatName.Dexterity, 10);
        charStats.put(StatName.Constitution, 12);
        charStats.put(StatName.Intelligence, 10);
        charStats.put(StatName.Wisdom, 10);
        charStats.put(StatName.Charisma, 10);

        charData.setStats(charStats);

        Character character = new Character(charData, charData.getLevel());
        assertEquals(character.getHealth(), 6);


        Character character2 = new Character(charData, 2);
        assertEquals(character2.getHealth(), 11);

    }

    @Test
    public void saveCharacterTest() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        Job charJob = new Job("Rogue");
        List<Feature> featureList = charJob.getFeatures();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);

        CharacterDataClass charData = new CharacterDataClass();
        charData.setBackground("Orphan");
        charData.setRaceName("Dwarf");
        charData.setJobName("Rogue");
        charData.setName("Gregg");
        charData.setAlignment("Chaotic Good");
        charData.setLevel(1);
        charData.setInventory(inventory);

        HashMap<StatName, Integer> charStats  = new HashMap<>();
        charStats.put(StatName.Strength, 10);
        charStats.put(StatName.Dexterity, 10);
        charStats.put(StatName.Constitution, 12);
        charStats.put(StatName.Intelligence, 10);
        charStats.put(StatName.Wisdom, 10);
        charStats.put(StatName.Charisma, 10);

        charData.setStats(charStats);

        Character character = new Character(charData, charData.getLevel());
        CharacterHandler.saveCharacter(character);
    }

    @Test
    public void testCalculateModifiers() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        CharacterDataClass charData = new CharacterDataClass();
        HashMap<StatName, Integer> charStats  = new HashMap<>();
        charStats.put(StatName.Strength, 5);
        charStats.put(StatName.Dexterity, 8);
        charStats.put(StatName.Constitution, 10);
        charStats.put(StatName.Intelligence, 15);
        charStats.put(StatName.Wisdom, 17);
        charStats.put(StatName.Charisma, 18);
        charData.setStats(charStats);
        Character character = new Character(charData, 1);
        HashMap<StatName, Integer> modifiers = character.calculateModifiers();
        System.out.println(modifiers.get(StatName.Strength));
        assertTrue(modifiers.get(StatName.Strength) == -4);
    }


}


