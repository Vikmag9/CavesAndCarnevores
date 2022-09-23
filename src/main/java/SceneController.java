import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.Arrays;
import java.util.List;

public class SceneController {
    @FXML private BorderPane borderPane;

    @FXML protected void openStartScreen() {
        FxmlHelper fxmlHelper = new FxmlHelper();
        Pane view = fxmlHelper.loadFxml("StartScreen");
        borderPane.setCenter(view);
    }

    @FXML private void openCreateCharacterScreen() {
        FxmlHelper fxmlHelper = new FxmlHelper();
        Pane view = fxmlHelper.loadFxml("Wizard");
        borderPane.setCenter(view);
    }

    /*-------------FROM Wizard------------
    //Generall
    @FXML private AnchorPane basicsPane;
    @FXML private AnchorPane inventoryPane;
    @FXML private AnchorPane jobSpecificPane;
    @FXML private AnchorPane lorePane;
    @FXML private AnchorPane satsAndSkillsPane;
    @FXML private AnchorPane weaponsAndArmourPane;
    @FXML private ImageView rightArrow;
    @FXML private ImageView leftArrow;
    @FXML private ImageView logoImage;
    @FXML private Button createCharacterHeaderButton;
    @FXML private Button myCharactersHeaderButton;

    private List<AnchorPane> AnchorPaneList = Arrays.asList(basicsPane,  jobSpecificPane,  satsAndSkillsPane, weaponsAndArmourPane, inventoryPane, lorePane);

    //Basics AnchorPane
    @FXML private TextField nameField;
    private String name;
    @FXML private ComboBox raceComboBox;
    @FXML private ComboBox jobComboBox;
    @FXML private ComboBox backgroundComboBox;
    @FXML private ComboBox levelComboBox;



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
