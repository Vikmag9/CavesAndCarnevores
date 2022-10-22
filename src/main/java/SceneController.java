import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * A controller that handles the main scene of the application.
 * The different methods handle the different fxml files that are loaded into a border pane in the base screen.
 */
public class SceneController implements Initializable {
    @FXML private BorderPane borderPane;
    @FXML private Button CreateCharacterHeaderButton;
    @FXML private Button MyCharactersHeaderButton;


    //navigational methods to switch fxml files in the center part of the border pane

    @FXML private void openStartScreen() {
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

    @FXML private void openCharacterScreen() {
        try {
            AnchorPane startScreen = FXMLLoader.load(getClass().getResource("Controllers.CharacterScreen.fxml"));
            borderPane.setCenter(startScreen);
        } catch (Exception e) {
            System.out.println("Error loading FXML file: " + e);
        }
    }

    //opens the start screen on launch

    /**
     * Initialize method that opens the start screen on launch.
     * The parameters are not used, but are required by the interface.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        openStartScreen();

    }





}
