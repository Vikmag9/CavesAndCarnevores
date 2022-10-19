import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class SceneController implements Initializable {
    @FXML private BorderPane borderPane;
    @FXML private Button CreateCharacterHeaderButton;
    @FXML private Button MyCharactersHeaderButton;


    //navigational methods to switch fxml files in the center part of the border pane
        @FXML protected void openStartScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL fxmlURL = Paths.get("src/main/resources/StartScreen.fxml").toUri().toURL();
            Parent startScreen = loader.load(fxmlURL);
            borderPane.setCenter(startScreen);
        } catch (Exception e) {
            System.out.println("Error loading FXML file: " + e);
        }
    }

    @FXML public void openCreateCharacterScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL fxmlURL = Paths.get("src/main/resources/Wizard.fxml").toUri().toURL();
            Parent startScreen = loader.load(fxmlURL);
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

    @FXML private void openCharacterScreen() {
        try {
            AnchorPane startScreen = FXMLLoader.load(getClass().getResource("CharacterScreen.fxml"));
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




}
