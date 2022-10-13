import Stats.Stats;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import Stats.StatView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WizardController implements Initializable{

    //General
    @FXML private AnchorPane basicsPane;
    @FXML private AnchorPane inventoryPane;
    @FXML private AnchorPane jobSpecificPane;
    @FXML private AnchorPane lorePane;
    @FXML private AnchorPane satsAndSkillsPane;
    @FXML private AnchorPane weaponsAndArmourPane;
    @FXML private StackPane stackPane;


    Stats stats = new Stats();
    StatView statView;

    //Basics AnchorPane
    @FXML private TextField nameField;
    @FXML private ComboBox<String> raceComboBox;
    @FXML private ComboBox<String> jobComboBox;
    @FXML private ComboBox<String> backgroundComboBox;

    //StatsAndSkill AnchorPane
    //Dex
    @FXML private CheckBox AcrobaticsCheckBox;
    @FXML private CheckBox SleightOfHandCheckBox;
    @FXML private CheckBox StealthCheckBox;

    //Wis
    @FXML private CheckBox AnimalHandlingCheckBox;
    @FXML private CheckBox InsightCheckBox;
    @FXML private CheckBox MedicineCheckBox;
    @FXML private CheckBox PerceptionCheckBox;
    @FXML private CheckBox SurvivalCheckBox;

    //Int
    @FXML private CheckBox ArcanaCheckBox;
    @FXML private CheckBox HistoryCheckBox;
    @FXML private CheckBox InvestigationCheckBox;
    @FXML private CheckBox NatureCheckBox;
    @FXML private CheckBox ReligionCheckBox;

    //Str
    @FXML private CheckBox AthleticsCheckBox;
    @FXML private CheckBox IntimidationCheckBox;

    //Cha
    @FXML private CheckBox DeceptionCheckBox;
    @FXML private CheckBox PerformanceCheckBox;
    @FXML private CheckBox PersuasionCheckBox;

    //Stats
    @FXML private TextField StrengthTextField;
    @FXML private TextField DexterityTextField;
    @FXML private TextField ConstitutionTextField;
    @FXML private TextField IntelligenceTextField;
    @FXML private TextField WisdomTextField;
    @FXML private TextField CharismaTextField;




    //WeaponsAndArmour AnchorPane
    @FXML private ComboBox<String> weaponComboBox;
    @FXML private ComboBox<String> armourComboBox;
    @FXML private ComboBox<String> shieldComboBox;
    @FXML private ComboBox<String> additionalWeaponComboBox;

    //Inventory AnchorPane
    @FXML private ComboBox<String> inventoryComboBox1;
    @FXML private ComboBox<String> inventoryComboBox2;
    @FXML private ComboBox<String> inventoryComboBox3;
    @FXML private TextField inventoryTextField1;
    @FXML private TextField inventoryTextField2;
    @FXML private TextField inventoryTextField3;


    // Lore AnchorPane
    @FXML private TextField earlyLifeTextField;
    @FXML private TextField organisationTextField;
    @FXML private TextField coreMemoriesTextField;
    @FXML private Button finishButton;

    //JobSpecific AnchorPane
    @FXML private FlowPane jobSpecificFlowPane;

    //Radiobuttons on stats
    private ToggleGroup statToggleGroup;
    @FXML private RadioButton rollDropRadio;
    @FXML private RadioButton arrayRadio;
    @FXML private RadioButton nightmareRadio;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prepareComboBoxes();
        statView = new StatView();
        prepareRadioButtons();
    }

    //navigation methods for the wizard within the stackpane
    @FXML private void toBasicsPane() {
        basicsPane.toFront();
    }

    @FXML private void toStatsAndSkillPane() {
        satsAndSkillsPane.toFront();
    }

    @FXML private void toJobSpecificPane() {
        jobSpecificPane.toFront();
    }

    @FXML private void toWeaponsAndArmourPane() {
        weaponsAndArmourPane.toFront();
    }

    @FXML private void toInventoryPane() {
        inventoryPane.toFront();
    }

    @FXML private void toLorePane() {
        lorePane.toFront();
    }

    //preparing methods for the wizard
    protected void prepareComboBoxes(){
        raceComboBox.getItems().addAll("Human", "Elf", "Dwarf", "Halfling", "Dragonborn", "Gnome", "Half-Elf", "Half-Orc", "Tiefling");
        raceComboBox.getSelectionModel().selectFirst();

        jobComboBox.getItems().addAll("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard");
        jobComboBox.getSelectionModel().selectFirst();

        backgroundComboBox.getItems().addAll("Acolyte", "Charlatan", "Criminal", "Entertainer", "Folk Hero", "Guild Artisan", "Hermit", "Noble", "Outlander", "Sage", "Sailor", "Soldier", "Urchin");
        backgroundComboBox.getSelectionModel().selectFirst();
    }

    private void prepareRadioButtons(){
        statToggleGroup = new ToggleGroup();
        rollDropRadio.setToggleGroup(statToggleGroup);
        arrayRadio.setToggleGroup(statToggleGroup);
        nightmareRadio.setToggleGroup(statToggleGroup);
        statToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (statToggleGroup.getSelectedToggle() != null){
                    System.out.println("here");
                    RadioButton selected = (RadioButton) statToggleGroup.getSelectedToggle();
                    stats.chooseStrategy(selected.getText());
                    ArrayList<Integer> listOfStats = stats.getStats();
                    statView.updateStatView(listOfStats);

                }
            }
        });
    }

    private List<String> checkBoxProficiencyToList(){
        //this is not very extensible, however, due to how the game Dungeons & Dragons (5e) is written, there will never be a need to add more skill proficiencies.
        List<String> listOfProficiencies = new ArrayList<>();
        if (AcrobaticsCheckBox.isSelected()){
            listOfProficiencies.add("Acrobatics");
        }
        if (SleightOfHandCheckBox.isSelected()){
            listOfProficiencies.add("Sleight of Hand");
        }
        if (StealthCheckBox.isSelected()){
            listOfProficiencies.add("Stealth");
        }
        if (AnimalHandlingCheckBox.isSelected()){
            listOfProficiencies.add("Animal Handling");
        }
        if (InsightCheckBox.isSelected()){
            listOfProficiencies.add("Insight");
        }
        if (MedicineCheckBox.isSelected()){
            listOfProficiencies.add("Medicine");
        }
        if (PerceptionCheckBox.isSelected()){
            listOfProficiencies.add("Perception");
        }
        if (SurvivalCheckBox.isSelected()){
            listOfProficiencies.add("Survival");
        }
        if (ArcanaCheckBox.isSelected()){
            listOfProficiencies.add("Arcana");
        }
        if (HistoryCheckBox.isSelected()){
            listOfProficiencies.add("History");
        }
        if (InvestigationCheckBox.isSelected()){
            listOfProficiencies.add("Investigation");
        }
        if (NatureCheckBox.isSelected()){
            listOfProficiencies.add("Nature");
        }
        if (ReligionCheckBox.isSelected()){
            listOfProficiencies.add("Religion");
        }
        if (DeceptionCheckBox.isSelected()){
            listOfProficiencies.add("Deception");
        }
        if (IntimidationCheckBox.isSelected()){
            listOfProficiencies.add("Intimidation");
        }
        if (PerformanceCheckBox.isSelected()){
            listOfProficiencies.add("Performance");
        }
        if (PersuasionCheckBox.isSelected()){
            listOfProficiencies.add("Persuasion");
        }
        if (AthleticsCheckBox.isSelected()){
            listOfProficiencies.add("Athletics");
        }
        return listOfProficiencies;
    }


}




