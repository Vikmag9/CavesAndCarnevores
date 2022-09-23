import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class StartScreenController implements Initializable {

    private CCcontroller parentController;
    @FXML
    private Button createCharacterHeaderButton;
    @FXML
    private Button myCharactersHeaderButton;
    @FXML
    private Button createCharacterButton;
    @FXML
    private Button myCharactersButton;

    public StartScreenController(CCcontroller parentController) {
        this.parentController = parentController;
    }



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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("StartScreenController");
    }
}
