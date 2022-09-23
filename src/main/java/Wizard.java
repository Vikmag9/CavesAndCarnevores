import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wizard{
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






        /*
        private void setAnchorPaneInvisible(AnchorPane pane){
            pane.setVisible(false);
        }

        private void setAnchorPaneVisible(AnchorPane pane){
            pane.setVisible(true);
        }

         */

}



