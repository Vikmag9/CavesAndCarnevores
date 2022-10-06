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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        openStartScreen();
    }

    @FXML private void nextPane() {
        satsAndSkillsPane.toFront();
    }

    @FXML private void previousPane() {
        basicsPane.toFront();
    }


/*
    private void showNextPane() {
        for (int i = 0; i < AnchorPaneList.size(); i++) {
            if (AnchorPaneList.get(i).isVisible()) {
                AnchorPaneList.get(i).setVisible(false);
                AnchorPaneList.get(i + 1).setVisible(true);
                break;
            }
        }
    }

    private void showPreviousPane() {
        for (int i = 0; i < AnchorPaneList.size(); i++) {
            if (AnchorPaneList.get(i).isVisible()) {
                AnchorPaneList.get(i).setVisible(false);
                AnchorPaneList.get(i - 1).setVisible(true);
                break;
            }
        }
    }

    @FXML
    public void initializeWizard() {
        basicsPane.setVisible(true);
        jobSpecificPane.setVisible(false);
        satsAndSkillsPane.setVisible(false);
        weaponsAndArmourPane.setVisible(false);
        inventoryPane.setVisible(false);
        lorePane.setVisible(false);
    }


 */

    /*-------------FROM Wizard------------

    private void showNextPane() {
        for (int i = 0; i < AnchorPaneList.size(); i++) {
            if (AnchorPaneList.get(i).isVisible()) {
                AnchorPaneList.get(i).setVisible(false);
                AnchorPaneList.get(i + 1).setVisible(true);
                break;
            }
        }
    }

    private void showPreviousPane() {
        for (int i = 0; i < AnchorPaneList.size(); i++) {
            if (AnchorPaneList.get(i).isVisible()) {
                AnchorPaneList.get(i).setVisible(false);
                AnchorPaneList.get(i - 1).setVisible(true);
                break;
            }
        }
    }

    @FXML
    public void initialize() {
        basicsPane.setVisible(true);
        jobSpecificPane.setVisible(false);
        satsAndSkillsPane.setVisible(false);
        weaponsAndArmourPane.setVisible(false);
        inventoryPane.setVisible(false);
        lorePane.setVisible(false);
    }

    ---------------from StartScreen----------------
    public class StartScreen {
    @FXML
    private Button createCharacterHeaderButton;
    @FXML
    private Button myCharactersHeaderButton;
    @FXML
    private Button createCharacterButton;
    @FXML
    private Button myCharactersButton;


    @FXML
    public void createCharacter() throws IOException {
        // Sends user to the Character Creator Wizard

        //tried a solution, not sure if we should use it - bats
        //It started opening duplicate windows after I added fx-ids????? -bats
        Parent root = FXMLLoader.load(getClass().getResource("Wizard.fxml"));
        Stage wizardStage = new Stage();

        wizardStage.setScene(new Scene(root, 300, 275));
        wizardStage.show();
        wizardStage.setMaximized(true);

    }

    @FXML


    public static void myCharacters(){
        // Sends user to the Characters Screen with previously created characters
    }

*/



}
