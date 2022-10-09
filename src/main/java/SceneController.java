import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class SceneController implements Initializable {
    @FXML private BorderPane borderPane;
    @FXML private Button CreateCharacterHeaderButton;
    @FXML private Button MyCharactersHeaderButton;

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




    //navigational methods to switch fxml files in the center part of the border pane
        @FXML protected void openStartScreen() {
        try {

            AnchorPane startScreen = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
            borderPane.setCenter(startScreen);
        } catch (Exception e) {
            System.out.println("Error loading FXML file: " + e);
        }
    }

    @FXML public void openCreateCharacterScreen() throws IOException, ClassNotFoundException {
        try {
            AnchorPane startScreen = FXMLLoader.load(getClass().getResource("Wizard.fxml"));
            borderPane.setCenter(startScreen);
        } catch (Exception e) {
            System.out.println("Error loading FXML file: " + e);
        }

    }

    @FXML private void openCharacterInfoScreen() {
        try {
            AnchorPane startScreen = FXMLLoader.load(getClass().getResource("CharacterInfoScreen.fxml"));
            borderPane.setCenter(startScreen);
        } catch (Exception e) {
            System.out.println("Error loading FXML file: " + e);
        }
    }

    //opens the start screen on launch
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        openStartScreen();

        //prepareComboBoxes();
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
