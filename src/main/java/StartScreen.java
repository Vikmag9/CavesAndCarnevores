import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

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

}
