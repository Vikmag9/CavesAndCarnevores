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
    private CharacterViewController parentController;
    private Character character;
    private Inventory inventory;


    @FXML private Text itemNameText;
    @FXML private Text itemTypeText;
    @FXML private Text itemMagicalText;
    @FXML private Text itemAttackBonusText;
    @FXML private Text itemACText;
    @FXML private Text itemValueText;

    @FXML private TextArea itemDescriptionTextArea;

    @FXML private Button itemSellButton;
    @FXML private Button itemRemoveButton;
    @FXML private Button itemConsumeButton;

    public CharacterListItem(InventoryItem item, CharacterViewController characterViewController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Controllers.CharacterListItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.parentController = characterViewController;
        populateCharacterListView(item);


    }

    private void populateCharacterListView(InventoryItem item) {
        itemNameText.setText(item.getItemName());
        itemDescriptionTextArea.setText(item.getItemDescription());
        itemTypeText.setText(item.getItemType());
        itemMagicalText.setText(valueOf(item.getIsMagical()));
        itemAttackBonusText.setText(valueOf(item.getAtkBonus()));
        itemACText.setText(valueOf(item.getAc()));
        itemValueText.setText(valueOf(item.getItemValue()));

    }
}
