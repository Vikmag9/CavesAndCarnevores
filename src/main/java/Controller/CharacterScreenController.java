package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CharacterScreenController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCharacterArea();
    }
    @FXML
    private void setCharacterArea(){
        // Load all existing characters to the flowpane in Controller.CharacterScreen.fxml
    }
    @FXML
    private void deleteCharacter(){
        // Delete a preexisting character
    }

}
