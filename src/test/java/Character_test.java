import Items.Inventory;
import Items.InventoryItem;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/*
public class Character_test {

    @Test
    public void createBarbarianTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Barbarian");
        List<Feature> featureList = charJob.getFeatures();
        List<InventoryItem> inventoryList = new ArrayList<>();
        Armour cheeseArmor = new Armour(12, "Armor", "Cheese-tplate", "A cheese-splate", 15, 10.0, true);
        cheeseArmor.equip();
        inventoryList.add(cheeseArmor);
        Inventory inventory = new Inventory(inventoryList,0);

        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }
            public int getMovementSpeed() {
                return 30;
            }
            public List<String> getRaceActions() {
                return null;
            }
        },
                charJob,
                featureList,
                inventory,
                1);


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getRaceName(), "Batman");
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
        List<InventoryItem> inventoryList = new ArrayList<>();
        Armour cheeseArmor = new Armour(12, "Armor", "Cheese-tplate", "A cheese-splate", 15, 10.0, true);
        cheeseArmor.equip();
        inventoryList.add(cheeseArmor);
        Inventory inventory = new Inventory(inventoryList,0);

        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }
            public int getMovementSpeed() {
                return 30;
            }
            public List<String> getRaceActions() {
                return null;
            }
        },
                charJob,
                featureList,
                inventory,
                1);


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getRaceName(), "Batman");
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
        List<InventoryItem> inventoryList = new ArrayList<>();
        Armour cheeseArmor = new Armour(12, "Armor", "Cheese-tplate", "A cheese-splate", 15, 10.0, true);
        cheeseArmor.equip();
        inventoryList.add(cheeseArmor);
        Inventory inventory = new Inventory(inventoryList, 0);
        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }

            public int getMovementSpeed() {
                return 30;
            }

            public List<String> getRaceActions() {
                return null;
            }
        },
                charJob,
                featureList,
                inventory,
                1);


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getRaceName(), "Batman");
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
        List<InventoryItem> inventoryList = new ArrayList<>();
        Armour cheeseArmor = new Armour(12, "Armor", "Cheese-tplate", "A cheese-splate", 15, 10.0, true);
        cheeseArmor.equip();
        inventoryList.add(cheeseArmor);
        Inventory inventory = new Inventory(inventoryList, 0);
        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }

            public int getMovementSpeed() {
                return 30;
            }

            public List<String> getRaceActions() {
                return null;
            }
        },
                charJob,
                featureList,
                inventory,
                1);


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getRaceName(), "Batman");
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
            List<InventoryItem> inventoryList = new ArrayList<>();
            Armour cheeseArmor = new Armour(12, "Armor", "Cheese-tplate", "A cheese-splate", 15, 10.0, true);
            cheeseArmor.equip();
            inventoryList.add(cheeseArmor);
            Inventory inventory = new Inventory(inventoryList, 0);
            Character character = new Character("Gregg", new Race() {
                public String getRaceName() {
                    return "Batman";
                }

                public int getMovementSpeed() {
                    return 30;
                }

                public List<String> getRaceActions() {
                    return null;
                }
            },
                    charJob,
                    featureList,
                    inventory,
                    1);


            assertEquals(character.getName(), "Gregg");
            assertEquals(character.getRace().getRaceName(), "Batman");
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
        List<InventoryItem> inventoryList = new ArrayList<>();
        Armour cheeseArmor = new Armour(12, "Armor", "Cheese-tplate", "A cheese-splate", 15, 10.0, true);
        cheeseArmor.equip();
        inventoryList.add(cheeseArmor);
        Inventory inventory = new Inventory(inventoryList, 0);
        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }

            public int getMovementSpeed() {
                return 30;
            }

            public List<String> getRaceActions() {
                return null;
            }
        },
                charJob,
                featureList,
                inventory,
                1);


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getRaceName(), "Batman");
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
        List<InventoryItem> inventoryList = new ArrayList<>();
        Armour cheeseArmor = new Armour(12, "Armor", "Cheese-tplate", "A cheese-splate", 15, 10.0, true);
        cheeseArmor.equip();
        inventoryList.add(cheeseArmor);
        Inventory inventory = new Inventory(inventoryList, 0);
        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }

            public int getMovementSpeed() {
                return 30;
            }

            public List<String> getRaceActions() {
                return null;
            }
        },
                charJob,
                featureList,
                inventory,
                1);


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getRaceName(), "Batman");
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
        List<InventoryItem> inventoryList = new ArrayList<>();
        Armour cheeseArmor = new Armour(12, "Armor", "Cheese-tplate", "A cheese-splate", 15, 10.0, true);
        cheeseArmor.equip();
        inventoryList.add(cheeseArmor);
        Inventory inventory = new Inventory(inventoryList, 0);
        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }

            public int getMovementSpeed() {
                return 30;
            }

            public List<String> getRaceActions() {
                return null;
            }
        },
                charJob,
                featureList,
                inventory,
                1);


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getRaceName(), "Batman");
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
        List<InventoryItem> inventoryList = new ArrayList<>();
        Armour cheeseArmor = new Armour(12, "Armor", "Cheese-tplate", "A cheese-splate", 15, 10.0, true);
        cheeseArmor.equip();
        inventoryList.add(cheeseArmor);
        Inventory inventory = new Inventory(inventoryList, 0);
        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }

            public int getMovementSpeed() {
                return 30;
            }

            public List<String> getRaceActions() {
                return null;
            }
        },
                charJob,
                featureList,
                inventory,
                1);


        assertEquals(character.getName(), "Gregg");
        assertEquals(character.getRace().getRaceName(), "Batman");
        assertEquals(character.getJob().getJobName(), "Rogue");
        assertEquals(character.getFeats(), featureList);
        assertEquals(character.getInventory(), inventory);
        assertEquals(character.getHealth(), 5);
        assertEquals(character.getArmorClass(), 12);
    }



    @Test
    public void testBarbarianParsing() throws IOException, ClassNotFoundException {
        Character BarbarianCharacter = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }

            public int getMovementSpeed() {
                return 30;
            }

            public List<String> getRaceActions() {
                return null;
            }
        },
                new Job("Barbarian"),
                null,
                null,
                1);

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
}
*/