import javafx.fxml.FXML;

import java.awt.*;

public class StartScreen {
    @FXML
    private Button createCharacterHeaderButton;
    @FXML
    private Button myCharactersHeaderButton;
    @FXML
    private Button createCharacterButton;
    @FXML
    private Button myCharactersButton;

    public static void createCharacter(){
        // Sends user to the Character Creator Wizard
    }

    public static void myCharacters(){
        // Sends user to the Characters Screen with previously created characters
    }

}
