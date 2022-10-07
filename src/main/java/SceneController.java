import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

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
    @FXML private ImageView rightArrow;
    @FXML private ImageView leftArrow;
    @FXML private ImageView logoImage;
    @FXML private StackPane stackPane;

    private List<AnchorPane> AnchorPaneList = Arrays.asList(basicsPane,  jobSpecificPane,  satsAndSkillsPane, weaponsAndArmourPane, inventoryPane, lorePane);

    //Basics AnchorPane
    @FXML private TextField nameField;
    private String name;
    @FXML private ComboBox raceComboBox;
    @FXML private ComboBox jobComboBox;
    @FXML private ComboBox backgroundComboBox;
    @FXML private ComboBox levelComboBox;


    //navigational methods to switch fxml files in the center part of the border pane
    @FXML protected void openStartScreen() {
        try {
            AnchorPane startScreen = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
            borderPane.setCenter(startScreen);
        } catch (Exception e) {
            System.out.println("Error loading FXML file: " + e);
        }
    }

    @FXML private void openCreateCharacterScreen() {
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



}
