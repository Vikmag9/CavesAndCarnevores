
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.*;

public class CharacterViewController implements Initializable {


    //Basics tab fx:ids
    @FXML private Text strengthsPtsText;
    @FXML private Text dexterityPtsText;
    @FXML private Text constitutionPtsText;
    @FXML private Text wisdomPtsText;
    @FXML private Text intelligencePtsText;
    @FXML private Text charismaPtsText;

    @FXML private Text strengthModifierText;
    @FXML private Text dexterityModifierText;
    @FXML private Text constitutionModifierText;
    @FXML private Text wisdomModifierText;
    @FXML private Text intelligenceModifierText;
    @FXML private Text charismaModifierText;

    @FXML private Circle strengthSavingThrowCircle;
    @FXML private Circle dexteritySavingThrowCircle;
    @FXML private Circle constitutionSavingThrowCircle;
    @FXML private Circle wisdomSavingThrowCircle;
    @FXML private Circle intelligenceSavingThrowCircle;
    @FXML private Circle charismaSavingThrowCircle;

    @FXML private Circle athleticsSkillStatus;
    @FXML private Circle acrobaticsSkillStatus;
    @FXML private Circle sleightOfHandSkillStatus;
    @FXML private Circle stealthSkillStatus;
    @FXML private Circle arcanaSkillStatus;
    @FXML private Circle historySkillStatus;
    @FXML private Circle investigationSkillStatus;
    @FXML private Circle natureSkillStatus;
    @FXML private Circle religionSkillStatus;
    @FXML private Circle animalHandlingSkillStatus;
    @FXML private Circle insightSkillStatus;
    @FXML private Circle medicineSkillStatus;
    @FXML private Circle perceptionSkillStatus;
    @FXML private Circle survivalSkillStatus;
    @FXML private Circle deceptionSkillStatus;
    @FXML private Circle intimidationSkillStatus;
    @FXML private Circle performanceSkillStatus;
    @FXML private Circle persuasionSkillStatus;

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

    @FXML private TextArea actionsTextArea;
    @FXML private TextArea reactionsTextArea;
    @FXML private TextArea bonusActionsTextArea;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setActionsTextArea();
        setReactionsTextArea();
        setBonusActionsTextArea();
        prepareRadioButtons();
    }

    // Basics features

    // Combat features

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

        actionsTextArea.setText(actions);
    }

    private void setReactionsTextArea() {
        String reactions = """
                - Opportunity Attack
                - Perform a readied action
                - Cast a spell
                """;

        reactionsTextArea.setText(reactions);
    }

    private void setBonusActionsTextArea() {
        String bonusActions = """
                - Offhand Attack
                - Cast a spell
                - Use a Class Feature
                """;

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

    private void prepareSpell(Map<String, String> map) {
        String name = map.get("name");
        String level = map.get("level");
        String description = map.get("description");
        String jobb = map.get("class");
        List<String> spell = Arrays.asList(jobb, level, name, description);
        spellList.add(spell);
    }

    @FXML
    private void disablecheckboxes(Boolean bool) {

            acCheckBox.setDisable(bool);
            atkBonusCheckBox.setDisable(bool);



    }

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


}
