import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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
    @FXML private ImageView logoImage;
    @FXML private StackPane stackPane;

    private List<AnchorPane> AnchorPaneList = Arrays.asList(basicsPane,  jobSpecificPane,  satsAndSkillsPane, weaponsAndArmourPane, inventoryPane, lorePane);

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

    //StatView
    @FXML private Label StatView1Big;
    @FXML private Label StatView2Big;
    @FXML private Label StatView3Big;
    @FXML private Label StatView4Big;
    @FXML private Label StatView5Big;
    @FXML private Label StatView6Big;
    @FXML private Label StatView1Small;
    @FXML private Label StatView2Small;
    @FXML private Label StatView3Small;
    @FXML private Label StatView4Small;
    @FXML private Label StatView5Small;
    @FXML private Label StatView6Small;


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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prepareComboBoxes();
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

    protected void prepareComboBoxes(){
        raceComboBox.getItems().addAll("Human", "Elf", "Dwarf", "Halfling", "Dragonborn", "Gnome", "Half-Elf", "Half-Orc", "Tiefling");
        raceComboBox.getSelectionModel().selectFirst();

        jobComboBox.getItems().addAll("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard");
        jobComboBox.getSelectionModel().selectFirst();

        backgroundComboBox.getItems().addAll("Acolyte", "Charlatan", "Criminal", "Entertainer", "Folk Hero", "Guild Artisan", "Hermit", "Noble", "Outlander", "Sage", "Sailor", "Soldier", "Urchin");
        backgroundComboBox.getSelectionModel().selectFirst();
    }

}
