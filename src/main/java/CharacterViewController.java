
import Items.Inventory;
import Items.InventoryItem;
import Items.InventoryItemBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class CharacterViewController implements Initializable {

    @FXML private CheckBox athleticsCheck;
    @FXML private CheckBox acrobaticsCheck;
    @FXML private CheckBox sleightCheck;
    @FXML private CheckBox stealthCheck;
    @FXML private CheckBox arcanaCheck;
    @FXML private CheckBox historyCheck;
    @FXML private CheckBox investigationCheck;
    @FXML private CheckBox natureCheck;
    @FXML private CheckBox religionCheck;
    @FXML private CheckBox animalCheck;
    @FXML private CheckBox insightCheck;
    @FXML private CheckBox medicineCheck;
    @FXML private CheckBox perceptionCheck;
    @FXML private CheckBox survivalCheck;
    @FXML private CheckBox deceptionCheck;
    @FXML private CheckBox intimidationCheck;
    @FXML private CheckBox performanceCheck;
    @FXML private CheckBox persuasionCheck;

    @FXML private TextField strengthText;
    @FXML private TextField dexText;
    @FXML private TextField conText;
    @FXML private TextField wisText;
    @FXML private TextField intText;
    @FXML private TextField chaText;


    @FXML private CheckBox g;
    @FXML private CheckBox f;
    @FXML private CheckBox h;
    @FXML private CheckBox d;


    //Basics tab fx:ids

    @FXML private Text strengthModifierText;
    @FXML private Text dexterityModifierText;
    @FXML private Text constitutionModifierText;
    @FXML private Text wisdomModifierText;
    @FXML private Text intelligenceModifierText;
    @FXML private Text charismaModifierText;


    @FXML private Text athleticsSkillLevelText;
    @FXML private Text acrobaticsSkillLevelText;
    @FXML private Text sleightOfHandSkillLevelText;
    @FXML private Text stealthSkillLevelText;
    @FXML private Text arcanaSkillLevelText;
    @FXML private Text historySkillLevelText;
    @FXML private Text investigationSkillLevelText;
    @FXML private Text natureSkillLevelText;
    @FXML private Text religionSkillLevelText;
    @FXML private Text animalHandlingSkillLevelText;
    @FXML private Text insightSkillLevelText;
    @FXML private Text medicineSkillLevelText;
    @FXML private Text perceptionSkillLevelText;
    @FXML private Text survivalSkillLevelText;
    @FXML private Text deceptionSkillLevelText;
    @FXML private Text intimidationSkillLevelText;
    @FXML private Text performanceSkillLevelText;
    @FXML private Text persuasionSkillLevelText;

    @FXML private TextArea spellsTextArea;
    @FXML private TextArea languagesTextArea;
    @FXML private TextArea proficienciesTextArea;

    @FXML Label characterNameLabel;
    @FXML Label characterRaceLabel;
    @FXML Label characterClassLabel;
    @FXML Label characterLevelLabel;


    @FXML TextField nameTextField;
    @FXML TextField raceTextField;
    @FXML TextField jobTextField;

    // Combat fx:ids

    @FXML private Text strengthCombatPtsText;
    @FXML private Text dexterityCombatPtsText;
    @FXML private Text constitutionCombatPtsText;
    @FXML private Text wisdomCombatPtsText;
    @FXML private Text intelligenceCombatPtsText;
    @FXML private Text charismaCombatPtsText;

    @FXML private Text strengthCombatModifierText;
    @FXML private Text dexterityCombatModifierText;
    @FXML private Text constitutionCombatModifierText;
    @FXML private Text wisdomCombatModifierText;
    @FXML private Text intelligenceCombatModifierText;
    @FXML private Text charismaCombatModifierText;

    @FXML private Text acText;
    @FXML private Text initiativeText;
    @FXML private Text movementSpeedText;
    @FXML private Text HitpointsText;

    @FXML private TextArea actionsTextArea;
    @FXML private TextArea reactionsTextArea;
    @FXML private TextArea bonusActionsTextArea;

    @FXML private Text HitPointsText;

    @FXML private FlowPane spellsFlowPane;

    List<List<String>> spellList;
    Character character;



    // Spells fx:ids

    @FXML private Button level1SpellsButton;
    @FXML private Button level2SpellsButton;
    @FXML private Button level3SpellsButton;
    @FXML private Button level4SpellsButton;
    @FXML private Button level5SpellsButton;
    @FXML private Button level6SpellsButton;
    @FXML private Button level7SpellsButton;
    @FXML private Button level8SpellsButton;
    @FXML private Button level9SpellsButton;


    // Lore & Notes fx:ids

    @FXML private TextArea earlierLifeTextArea;
    @FXML private TextArea organizationTextArea;
    @FXML private TextArea coreMemoriesTextArea;
    @FXML private TextArea notesTextArea;

    @FXML private Button loreAndNotesSaveButton;

    // Inventory fx:ids

    @FXML private RadioButton equippableRadioButton;
    @FXML private RadioButton consumableRadioButton;
    @FXML private RadioButton miscellaneousRadioButton;

    @FXML private CheckBox acCheckBox;
    @FXML private CheckBox atkBonusCheckBox;
    @FXML private CheckBox isMagicalCheckBox;

    @FXML private FlowPane inventoryFlowPane;
    @FXML private TextField currentGoldTextField;

    //listItem fx-ids
    @FXML private TextField itemNameTextField;
    @FXML private TextField itemValueTextField;
    @FXML private TextArea itemCreationDescriptionTextArea;


    @FXML private Button createItemButton;
    @FXML private Button clearItemCreationButton;


    @FXML private Text itemNameText;
    @FXML private Text itemTypeText;
    @FXML private Text itemMagicalText;
    @FXML private Text itemAttackBonusText;
    @FXML private Text itemACText;
    @FXML private Text itemValueText;

    @FXML private TextArea itemDescriptionTextArea;

    @FXML private Button itemSellButton;
    @FXML private Button itemRemoveButton;
    @FXML private Button itemConsumeButton;

    /**
     * Initializes the controller class for the CharacterInfoScreen.fxml.
     * A necessary method for the FXML to work, since it is needed for the initializeable interface.
     * Prepares the components that need initialization, such as textareas and radiobuttons.
     * The parameters are not used in the method calls but are necessary to implement the initializeable interface.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        System.out.println("here");

        setActionsTextArea();
        setReactionsTextArea();
        setBonusActionsTextArea();
        prepareRadioButtons();
        prepareCheckBoxes(new ArrayList<ProficiencySkills>(List.of(ProficiencySkills.Acrobatics)));
        prepareName("Gregg");
        HashMap<StatName, Integer> stats = new HashMap<>();
        stats.put(StatName.Strength, 10);
        stats.put(StatName.Constitution, 10);
        stats.put(StatName.Wisdom, 10);
        stats.put(StatName.Intelligence, 10);
        stats.put(StatName.Charisma, 10);
        stats.put(StatName.Dexterity, 10);
        prepareStats(stats);
        prepareModifiers();
    }

    private Character getCharacter() throws IOException, ClassNotFoundException, CloneNotSupportedException{
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

        charData.setProficiencies(true, ProficiencySkills.Athletics);


        charData.setStats(charStats);

        Character character = new Character(charData, charData.getLevel());
        return character;
    }

    // Basics features

    // Combat features

    /**
     * Sets the actions to be displayed in the text area.
     * Could be used to set the actions specific to the character, but is currently set to a generalized text that work for all characters.
     */
    private void setActionsTextArea() {
        String actions = """
                - Attack
                - Dash
                - Disengage
                - Dodge
                - Help
                - Hide
                - Search
                - Use an Object
                - Grapple
                - Shove
                - Cast a Spell
                - Ready An Action
                - Use a Class Feature""";

        actionsTextArea.setEditable(false);
        actionsTextArea.setText(actions);
    }

    /**
     * Sets the reactions to be displayed in the text area.
     * Could be used to set the reactions specific to the character, but is currently set to a generalized text that work for all characters.
     */
    private void setReactionsTextArea() {
        String reactions = """
                - Opportunity Attack
                - Perform a readied action
                - Cast a spell
                """;

        reactionsTextArea.setEditable(false);
        reactionsTextArea.setText(reactions);
    }

    /**
     * Sets the bonus actions to be displayed in the text area.
     * Could be used to set the bonus actions specific to the character, but is currently set to a generalized text that work for all characters.
     */
    private void setBonusActionsTextArea() {
        String bonusActions = """
                - Offhand Attack
                - Cast a spell
                - Use a Class Feature
                """;

        bonusActionsTextArea.setEditable(false);
        bonusActionsTextArea.setText(bonusActions);
    }

    private void prepareSpells() {
        List<List<String>> sortedSpellList = new ArrayList<>();
        List<List<String>> level1spells = new ArrayList<>();
        for (List<String> spell : spellList) {
            String spellJobb = spell.get(0);
            if (Objects.equals(spellJobb, character.getJob().getJobName())) {
                sortedSpellList.add(spell);
            }
        }

        for (List<String> spell : sortedSpellList) {
            String spellLevel = spell.get(1);
            if (Objects.equals(spellLevel, "1")) {
                level1spells.add(spell);
            }
        }

        for (List<String> spell : level1spells) {
            String spellName = spell.get(2);
            String spellDescription = spell.get(3);
            spellsFlowPane.getChildren().add(new Label(spellName + "\n" + spellDescription));

        }
    }

    private void prepareName(String string){
        nameTextField.setText(string);
    }

    private void prepareRace(String string){
        raceTextField.setText(string);
    }

    private void prepareJob(String string){
        jobTextField.setText(string);
    }

    private void prepareStats(HashMap<StatName, Integer> stats){
        strengthText.setText(stats.get(StatName.Strength).toString());
        conText.setText(stats.get(StatName.Constitution).toString());
        wisText.setText(stats.get(StatName.Wisdom).toString());
        chaText.setText(stats.get(StatName.Charisma).toString());
        intText.setText(stats.get(StatName.Intelligence).toString());
        dexText.setText(stats.get(StatName.Dexterity).toString());
    }

    private void prepareModifiers(){
        strengthModifierText.setText("5");
    }

    private void prepareSpell(Map<String, String> map) {
        String name = map.get("name");
        String level = map.get("level");
        String description = map.get("description");
        String jobb = map.get("class");
        List<String> spell = Arrays.asList(jobb, level, name, description);
        spellList.add(spell);
    }

    private void prepareCheckBoxes(ArrayList<ProficiencySkills> proflist){

        if(proflist.contains(ProficiencySkills.Athletics)){
            athleticsCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Deception)) {
            deceptionCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Intimidation)) {
            intimidationCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Performance)) {
            performanceCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Persuasion)) {
            persuasionCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.AnimalHandling)) {
            animalCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Insight)) {
            insightCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Medicine)) {
            medicineCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Perception)) {
            perceptionCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Survival)) {
            survivalCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Arcana)) {
            arcanaCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.History)) {
            historyCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Investigation)) {
            investigationCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Nature)) {
            natureCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Religion)) {
            religionCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Acrobatics)) {
            acrobaticsCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.SleightOfHand)) {
            sleightCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Stealth)) {
            stealthCheck.setSelected(true);
        }
    }

    @FXML
    private void disablecheckboxes(Boolean bool) {

            acCheckBox.setDisable(bool);
            atkBonusCheckBox.setDisable(bool);



    }

    /**
     * Prepares the radio buttons for the inventory.
     * Disables the checkboxes for consumable items.
     */
    private void prepareRadioButtons(){
        ToggleGroup itemToggleGroup = new ToggleGroup();
        consumableRadioButton.setToggleGroup(itemToggleGroup);
        equippableRadioButton.setToggleGroup(itemToggleGroup);
        miscellaneousRadioButton.setToggleGroup(itemToggleGroup);
        itemToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (itemToggleGroup.getSelectedToggle() != null){
                    RadioButton selected = (RadioButton) itemToggleGroup.getSelectedToggle();
                    System.out.println(selected.getText());
                    if (consumableRadioButton.isSelected()){
                        disablecheckboxes(true);
                        System.out.println("disable");
                    }
                    else {
                        disablecheckboxes(false);
                        System.out.println("enable");
                    }


                }
            }
        });
    }

    // Spells features

    // Lore & Notes features

    @FXML
    private void saveLoreAndNotesTab(){
        // Save the current state of the Lore & Notes tab
    }

    // Inventory features

    private void updateInventoryList() {
        //Inventory inventory = character.getInventory();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);
        inventoryFlowPane.getChildren().clear();
        List<InventoryItem> items = inventory.getInventory();
        for (InventoryItem item : items) {
            CharacterListItem rli = new CharacterListItem(item, this);
            inventoryFlowPane.getChildren().add(rli);
        }
    }
}
