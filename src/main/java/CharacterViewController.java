
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
    @FXML Text strengthsPtsText;
    @FXML Text dexterityPtsText;
    @FXML Text constitutionPtsText;
    @FXML Text wisdomPtsText;
    @FXML Text intelligencePtsText;
    @FXML Text charismaPtsText;

    @FXML Text strengthModifierText;
    @FXML Text dexterityModifierText;
    @FXML Text constitutionModifierText;
    @FXML Text wisdomModifierText;
    @FXML Text intelligenceModifierText;
    @FXML Text charismaModifierText;

    @FXML Circle strengthSavingThrowCircle;
    @FXML Circle dexteritySavingThrowCircle;
    @FXML Circle constitutionSavingThrowCircle;
    @FXML Circle wisdomSavingThrowCircle;
    @FXML Circle intelligenceSavingThrowCircle;
    @FXML Circle charismaSavingThrowCircle;

    @FXML Circle athleticsSkillStatus;
    @FXML Circle acrobaticsSkillStatus;
    @FXML Circle sleightOfHandSkillStatus;
    @FXML Circle stealthSkillStatus;
    @FXML Circle arcanaSkillStatus;
    @FXML Circle historySkillStatus;
    @FXML Circle investigationSkillStatus;
    @FXML Circle natureSkillStatus;
    @FXML Circle religionSkillStatus;
    @FXML Circle animalHandlingSkillStatus;
    @FXML Circle insightSkillStatus;
    @FXML Circle medicineSkillStatus;
    @FXML Circle perceptionSkillStatus;
    @FXML Circle survivalSkillStatus;
    @FXML Circle deceptionSkillStatus;
    @FXML Circle intimidationSkillStatus;
    @FXML Circle performanceSkillStatus;
    @FXML Circle persuasionSkillStatus;

    @FXML TextArea spellsTextArea;
    @FXML TextArea languagesTextArea;
    @FXML TextArea proficienciesTextArea;

    @FXML Label characterNameLabel;
    @FXML Label characterRaceLabel;
    @FXML Label characterClassLabel;
    @FXML Label characterLevelLabel;


    // Combat fx:ids

    @FXML private Text strengthCombatPtsText;
    @FXML private Text dexterityCombatPtsText;
    @FXML private Text constitutionCombatPtsText;
    @FXML private Text wisdomCombatPtsText;
    @FXML private Text intelligenceCombatPtsText;
    @FXML private Text charismaCombatPtsText;

    @FXML private Text strengthCombatModifierPtsText;
    @FXML private Text dexterityCombatModifierPtsText;
    @FXML private Text constitutionCombatModifierPtsText;
    @FXML private Text wisdomCombatModifierPtsText;
    @FXML private Text intelligenceCombatModifierPtsText;
    @FXML private Text charismaCombatModifierPtsText;

    @FXML private TextArea actionsTextArea;
    @FXML private TextArea reactionsTextArea;
    @FXML private TextArea bonusActionsTextArea;

    @FXML private FlowPane spellsFlowPane;

    List<List<String>> spellList;
    Character character;

    @FXML private RadioButton equippableRadioButton;
    @FXML private RadioButton consumableRadioButton;
    @FXML private RadioButton miscellaneousRadioButton;

    @FXML private CheckBox acCheckBox;
    @FXML private CheckBox atkBonusCheckBox;
    @FXML private CheckBox isMagicalCheckBox;

    // Spells fx:ids

    // Lore & Notes fx:ids

    // Inventory fx:ids
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

}
