package Controllers;

import Model.*;
import Model.Character;
import Model.Items.Inventory;
import Model.Items.InventoryItem;
import Model.Items.InventoryItemBuilder;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class CharacterInfoScreenController implements Initializable {

    private Character character;

    @FXML private Button receiveDataButton;

    @FXML private CheckBox athleticsCheck, acrobaticsCheck,sleightCheck, stealthCheck,arcanaCheck,historyCheck,investigationCheck,natureCheck,religionCheck,animalCheck;
    @FXML private CheckBox insightCheck,medicineCheck,perceptionCheck,survivalCheck,deceptionCheck,intimidationCheck,performanceCheck,persuasionCheck;

    @FXML private TextField strengthText, dexText, conText, wisText, intText, chaText;
    @FXML private TextField proficiencyBonusText;


    //Basics tab fx:ids

    @FXML private Text strengthModifierText, dexterityModifierText, constitutionModifierText, wisdomModifierText, intelligenceModifierText, charismaModifierText;

    @FXML private Text athleticsSkillLevelText, acrobaticsSkillLevelText, sleightOfHandSkillLevelText, stealthSkillLevelText, arcanaSkillLevelText, historySkillLevelText, investigationSkillLevelText, natureSkillLevelText, religionSkillLevelText, animalHandlingSkillLevelText, insightSkillLevelText, medicineSkillLevelText, perceptionSkillLevelText, survivalSkillLevelText, deceptionSkillLevelText, intimidationSkillLevelText, performanceSkillLevelText, persuasionSkillLevelText;

    @FXML private TextArea spellsTextArea, languagesTextArea;

    @FXML Label characterLevelLabel;
    @FXML Text characterNameText, characterRaceText, characterClassText;

    // Combat fx:ids
    @FXML private TextArea spellTextArea;

    @FXML private Text HitPointsText;
    @FXML private FlowPane spellsFlowPane;
    List<List<String>> spellList;

    // Spells fx:ids

    @FXML private Button level1SpellsButton, level2SpellsButton, level3SpellsButton, level4SpellsButton, level5SpellsButton, level6SpellsButton, level7SpellsButton, level8SpellsButton, level9SpellsButton;

    // Lore & Notes fx:ids

    @FXML private TextArea earlierLifeTextArea, organizationTextArea, coreMemoriesTextArea, notesTextArea;

    @FXML private Button loreAndNotesSaveButton;

    // Inventory fx:ids

    @FXML private RadioButton equippableRadioButton, consumableRadioButton, miscellaneousRadioButton;
    @FXML private CheckBox acCheckBox, atkBonusCheckBox, isMagicalCheckBox;
    @FXML private FlowPane inventoryFlowPane;
    @FXML private TextField currentGoldTextField;

    //listItem fx-ids
    @FXML private TextField itemNameTextField, itemValueTextField;
    @FXML private TextArea itemCreationDescriptionTextArea;


    @FXML private Button createItemButton, clearItemCreationButton;

    @FXML private Text itemNameText, itemTypeText, itemMagicalText, itemAttackBonusText, itemACText, itemValueText;

    @FXML private TextArea itemDescriptionTextArea;

    @FXML private Button itemSellButton, itemRemoveButton, itemConsumeButton;

    @FXML private ListView<String> featureListView;
    @FXML private ListView<String> proficiencyListView;

    @FXML private TextField initiativeTextField, acTextField;

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
        this.character = CharacterSingleton.getInstance().getCharacter();

        prepareRadioButtons();
        System.out.println(character.getName());
        prepareCheckBoxes(character.getProficiencySkills());
        prepareStats(character.getStats());
        prepareModifiers(character.calculateModifiers());
        prepareName(character.getName());
        prepareRace(character.getRaceName());
        prepareJob(character.getJobName());
        prepareFeatures(character.getFeatures());
        prepareProficiencies(character.getProficiencies());
        prepareTextFields(character);
        updateSkillProficiencyModifiers();
        //updateInventoryList();
        //prepareSpells()
        prepareAC(character.getArmorClass());
        prepareInitiavitive(character.calculateModifiers());
    }

    private void prepareInitiavitive(HashMap<StatName, Integer> modifiers) {
        initiativeTextField.setText(Integer.toString(modifiers.get(StatName.Dexterity)));
    }

    private void prepareAC(int armorClass) {
        acTextField.setText(Integer.toString(armorClass));
        acTextField.textProperty().addListener((observable, oldValue, newValue) -> character.setArmorClass(Integer.parseInt(acTextField.getText())));

    }

    private void prepareReceiveDataButton() {
        receiveDataButton.setOnMouseClicked(event -> receiveData(event));
    }


    private void prepareFeatures(List<Feature> features) {
        features.forEach(feature -> {
            featureListView.getItems().add(feature.getName());
            featureListView.getItems().add(feature.getDesc());
        });
    }

    private void prepareProficiencies(Map<Proficiencies, List<String>> proficiencies) {
        for (Proficiencies category : Proficiencies.values()) {
            System.out.println(category);
            proficiencyListView.getItems().add(category.toString());
            List<String> profs = proficiencies.get(category);
            System.out.println(profs);
            for(String prof : profs){
                System.out.println(prof);
                proficiencyListView.getItems().add(prof);
            }
        }
    }


    /*private void prepareSpells() {
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
    }*/

    private void prepareName(String string){
        characterNameText.setText(string);
    }

    private void prepareRace(String string){
        characterRaceText.setText(string);
    }

    private void prepareJob(String string){
        characterClassText.setText(string);
    }

    private void prepareStats(HashMap<StatName, Integer> stats){
        strengthText.setText(stats.get(StatName.Strength).toString());
        conText.setText(stats.get(StatName.Constitution).toString());
        wisText.setText(stats.get(StatName.Wisdom).toString());
        chaText.setText(stats.get(StatName.Charisma).toString());
        intText.setText(stats.get(StatName.Intelligence).toString());
        dexText.setText(stats.get(StatName.Dexterity).toString());
        strengthText.textProperty().addListener((observable, oldValue, newValue) ->{
            character.setStrength(Integer.parseInt(strengthText.getText()));
            updateView();
        });
        conText.textProperty().addListener((observable, oldValue, newValue) ->{
            character.setConstitution(Integer.parseInt(conText.getText()));
            updateView();
        });
        wisText.textProperty().addListener((observable, oldValue, newValue) ->{
            character.setWisdom(Integer.parseInt(wisText.getText()));
            updateView();
        });
        chaText.textProperty().addListener((observable, oldValue, newValue) ->{
            character.setCharisma(Integer.parseInt(chaText.getText()));
            updateView();
        });
        intText.textProperty().addListener((observable, oldValue, newValue) ->{
            character.setIntelligence(Integer.parseInt(intText.getText()));
            updateView();
        });
        dexText.textProperty().addListener((observable, oldValue, newValue) ->{
            character.setDexterity(Integer.parseInt(dexText.getText()));
            updateView();
        });

    }

    private void updateView(){
        prepareModifiers(character.calculateModifiers());
        prepareInitiavitive(character.calculateModifiers());
    }

    private void prepareModifiers(HashMap<StatName, Integer> modifiers){
        strengthModifierText.setText(modifiers.get(StatName.Strength).toString());
        intelligenceModifierText.setText(modifiers.get(StatName.Intelligence).toString());
        wisdomModifierText.setText(modifiers.get(StatName.Wisdom).toString());
        constitutionModifierText.setText(modifiers.get(StatName.Constitution).toString());
        charismaModifierText.setText(modifiers.get(StatName.Charisma).toString());
        dexterityModifierText.setText(modifiers.get(StatName.Dexterity).toString());
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
    @FXML /* Disables the AC and Attack Bonus option when a Consumable item type is selected, as they cannot have either
    of those traits. */
    private void disablecheckboxes(Boolean bool) {

        acCheckBox.setDisable(bool);
        atkBonusCheckBox.setDisable(bool);
    }

    /* Prepares the radio buttons for the inventory. Calls on function that disables the AC and Attack Bonus checkboxes
    for consumable items. */
    private void prepareRadioButtons(){
        ToggleGroup itemToggleGroup = new ToggleGroup();
        consumableRadioButton.setToggleGroup(itemToggleGroup);
        equippableRadioButton.setToggleGroup(itemToggleGroup);
        miscellaneousRadioButton.setToggleGroup(itemToggleGroup);
        itemToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
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
        });
    }

    // Spells features

    // Lore & Notes features

   @FXML
    private void saveLoreAndNotesTab(){
        // Save the current state of the Lore & Notes tab
    }

    @FXML
    private void saveCharacter(){
        CharacterHandler.saveCharacter(this.character);
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
            ItemsListItem rli = new ItemsListItem(item, this);
            inventoryFlowPane.getChildren().add(rli);
        }
    }

    private void updateSkillProficiencyModifiers() {
        // Update the skill proficiency modifiers
        if (proficiencyBonusText.getText().isEmpty()) {
            proficiencyBonusText.setText("0");
        }
        Integer proficiencyB = Integer.valueOf(proficiencyBonusText.getText());
        List<CheckBox> skillsCheckList= Arrays.asList(athleticsCheck, deceptionCheck, intimidationCheck, performanceCheck, persuasionCheck, animalCheck, insightCheck, medicineCheck, perceptionCheck, survivalCheck, arcanaCheck, historyCheck, investigationCheck, natureCheck, religionCheck, acrobaticsCheck, sleightCheck, stealthCheck);
        List<Text> skillsModifierList = Arrays.asList(athleticsSkillLevelText, deceptionSkillLevelText, intimidationSkillLevelText, performanceSkillLevelText, persuasionSkillLevelText, animalHandlingSkillLevelText, insightSkillLevelText, medicineSkillLevelText, perceptionSkillLevelText, survivalSkillLevelText, arcanaSkillLevelText, historySkillLevelText, investigationSkillLevelText, natureSkillLevelText, religionSkillLevelText, acrobaticsSkillLevelText, sleightOfHandSkillLevelText, stealthSkillLevelText);
        List<Text> strenghtList = Arrays.asList(athleticsSkillLevelText, intimidationSkillLevelText);
        List<Text> dexterityList = Arrays.asList(acrobaticsSkillLevelText, sleightOfHandSkillLevelText, stealthSkillLevelText);
        List<Text> wisdomList = Arrays.asList(insightSkillLevelText, medicineSkillLevelText, perceptionSkillLevelText, survivalSkillLevelText);
        List<Text> intelligenceList = Arrays.asList(arcanaSkillLevelText, historySkillLevelText, investigationSkillLevelText, natureSkillLevelText, religionSkillLevelText);
        List<Text> charismaList = Arrays.asList(deceptionSkillLevelText, performanceSkillLevelText, persuasionSkillLevelText);
        for (int i = 0; i < skillsCheckList.size(); i++) {
            Integer modifier = 0;
            if (strenghtList.contains(skillsModifierList.get(i))) {
                modifier = Integer.valueOf(strengthModifierText.getText());
            }
            if (dexterityList.contains(skillsModifierList.get(i))) {
                modifier = Integer.valueOf(dexterityModifierText.getText());
            }
            if (wisdomList.contains(skillsModifierList.get(i))) {
                modifier = Integer.valueOf(wisdomModifierText.getText());
            }
            if (intelligenceList.contains(skillsModifierList.get(i))) {
                modifier = Integer.valueOf(intelligenceModifierText.getText());
            }
            if (charismaList.contains(skillsModifierList.get(i))) {
                modifier = Integer.valueOf(charismaModifierText.getText());
            }

            if (skillsCheckList.get(i).isSelected()) {
                modifier += proficiencyB;
            }
            skillsModifierList.get(i).setText(modifier.toString());

        }
    }


    private void receiveData(MouseEvent event) {
        // Step 1
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        // Step 2
        Character character = (Character) stage.getUserData();
        // Step 3
        String name = character.getName();
        String race = character.getRaceName();
        System.out.println(name);
        System.out.println(race);
        this.character = character;
    }

    private void prepareTextFields(Character character){
        coreMemoriesTextArea.setText("1");

    }





}

