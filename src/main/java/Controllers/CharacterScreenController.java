package Controllers;

import Model.Character;
import Model.CharacterHandler;
import Model.CharacterSingleton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CharacterScreenController implements Initializable {

    @FXML private Button sendDataButton;
    @FXML private FlowPane charactersFlowPane;
    @FXML private ComboBox<String> characterCombo;
    private String selectedCharacter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prepareCombobox();
        prepareSendData();
    }

    private void prepareCombobox() {
        List<Character> characters = CharacterHandler.loadAllCharacters();
        List<String> characterNames = new ArrayList<>();
        characters.forEach(character -> {
            characterNames.add(character.getName());
        });
        characterCombo.getItems().addAll(characterNames);
        characterCombo.getSelectionModel().selectFirst();
        characterCombo.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> selectedCharacter = newValue);
    }

    /*private void displayCharacters(){
        charactersFlowPane.getChildren().clear();
        /*CharacterHandler.loadAllCharacters().forEach(character ->{
            charactersFlowPane.getChildren().add(new CharacterListItem(character));
        });
        Character character = CharacterHandler.loadCharacter("Gregg");
        System.out.println("character loaded");
        CharacterListItem h = new CharacterListItem(character);
        System.out.println("listitem");
        charactersFlowPane.getChildren().add(h);


    }
*/
    private void prepareSendData() {
        sendDataButton.setOnMouseClicked(mouseEvent ->{
            CharacterSingleton.getInstance().setCharacter(CharacterHandler.loadCharacter(this.selectedCharacter));
            Node node = (Node) mouseEvent.getSource();
            // Step 3
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("CharacterInfoScreen.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Step 5
            // Step 6
            Scene scene = new Scene(root);
            stage.setScene(scene);
            // Step 7
            stage.show();
        });
    }


    @FXML
    private void deleteCharacter(){
        // Delete a preexisting character
    }


}
