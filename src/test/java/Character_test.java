import Items.CoinBag;
import Items.Inventory;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;

public class Character_test {
    @Test
    public void createCharacterTest() throws IOException, ClassNotFoundException {
        Job charJob = new Job("Barbarian");
        List<Feature> featureList = charJob.getFeatures();
        Inventory inventory = new Inventory(emptyList(), 0);

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
        assertEquals(character.getArmorClass(), 0);

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
