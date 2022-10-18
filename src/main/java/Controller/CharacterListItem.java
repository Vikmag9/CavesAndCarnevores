package Controller;

import Items.Inventory;
import Items.InventoryItem;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

import static java.lang.String.valueOf;

public class CharacterListItem  extends AnchorPane {
    private CharacterViewController parentController;
    private Character character;
    private InventoryItem item;



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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ItemsListItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        try {
            fxmlLoader.load();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.item = item;
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
