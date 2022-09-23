import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class WizardController implements Initializable {

    private CCcontroller parentController;
    //General
    @FXML
    protected AnchorPane basicsPane;
    @FXML protected AnchorPane inventoryPane;
    @FXML protected AnchorPane jobSpecificPane;
    @FXML protected AnchorPane lorePane;
    @FXML protected AnchorPane satsAndSkillsPane;
    @FXML protected AnchorPane weaponsAndArmourPane;
    @FXML protected ImageView rightArrow;
    @FXML protected ImageView leftArrow;
    @FXML protected ImageView logoImage;
    @FXML protected Button createCharacterHeaderButton;
    @FXML protected Button myCharactersHeaderButton;

    private List<AnchorPane> AnchorPaneList = Arrays.asList(basicsPane,  jobSpecificPane,  satsAndSkillsPane, weaponsAndArmourPane, inventoryPane, lorePane);

    //Basics AnchorPane
    @FXML protected TextField nameField;
    @FXML protected ComboBox raceComboBox;
    @FXML protected ComboBox jobComboBox;
    @FXML protected ComboBox backgroundComboBox;
    @FXML protected ComboBox levelComboBox;
    private String name;




    public WizardController(CCcontroller parentController) {
            this.parentController = parentController;
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    private void showNextPane() {
        System.out.println("Next Pane");
        for (int i = 0; i < AnchorPaneList.size(); i++) {
            if (AnchorPaneList.get(i).isVisible()) {
                AnchorPaneList.get(i).setVisible(false);
                AnchorPaneList.get(i + 1).setVisible(true);
                break;
            }
        }
    }

    @FXML
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

}
