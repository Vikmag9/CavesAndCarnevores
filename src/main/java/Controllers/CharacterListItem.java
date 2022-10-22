package Controllers;

import Model.Items.Inventory;
import Model.Items.InventoryItem;
import Model.Character;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Text;

import java.io.IOException;

import static java.lang.String.valueOf;

public class CharacterListItem  extends AnchorPane {
    private CharacterInfoScreenController parentController;
    private Character character;


    @FXML private Text characterCardNameText;
    @FXML private Text characterCardRaceText;
    @FXML private Text characterCardClassText;
    @FXML private Text characterCardLevelText;

    @FXML private Button characterCardDeleteButton;
    @FXML private Button characterCardViewButton;


    public CharacterListItem(Character character, CharacterInfoScreenController characterInfoScreenController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CharacterListItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.parentController = characterInfoScreenController;
        populateCharacterListView(character);


    }

    private void populateCharacterListView(Character character) {
        characterCardNameText.setText(character.getName());
        characterCardRaceText.setText(character.getRaceName());
        characterCardClassText.setText(character.getJobName());
        characterCardLevelText.setText(String.valueOf(character.getLevel()));
    }
}
