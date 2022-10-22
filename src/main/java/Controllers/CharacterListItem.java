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


    @FXML private Text characterCardNameText;
    @FXML private Text characterCardRaceText;
    @FXML private Text characterCardClassText;
    @FXML private Text characterCardLevelText;



    public CharacterListItem(Character character){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CharacterListItem.fxml"));
        System.out.println("loaded chosen");
        fxmlLoader.setRoot(this);
        System.out.println("root set");
        fxmlLoader.setController(this);
        System.out.println("controller set");

        try {
            fxmlLoader.load();
            System.out.println("fxml opened");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        System.out.println("fxml opened");

        populateCharacterListView(character);
        System.out.println("population complete");

    }

    private void populateCharacterListView(Character character) {
        characterCardNameText.setText(character.getName());
        characterCardRaceText.setText(character.getRaceName());
        characterCardClassText.setText(character.getJobName());
        characterCardLevelText.setText(String.valueOf(character.getLevel()));
    }
}
