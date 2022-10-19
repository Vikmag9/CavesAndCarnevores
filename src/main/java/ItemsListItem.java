import Items.Inventory;
import Items.InventoryItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Text;

import java.io.IOException;

import static java.lang.String.valueOf;

public class ItemsListItem  extends AnchorPane {
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

    public ItemsListItem(InventoryItem item, CharacterViewController characterViewController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ItemsListItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.parentController = characterViewController;
        populateInventoryListView(item);
    }

    private void populateInventoryListView(InventoryItem item) {
        itemNameText.setText(item.getItemName());
        itemDescriptionTextArea.setText(item.getItemDescription());
        itemTypeText.setText(item.getItemType());
        if (item.getIsMagical()){
            itemMagicalText.setVisible(true);
        }
        if (item.getAtkBonus() > 0){
            itemAttackBonusText.setVisible(true);
            itemAttackBonusText.setText("+ " + item.getAtkBonus() + " Atk Bonus");
        }
        if (item.getAc() > 0){
            itemACText.setVisible(true);
            itemACText.setText(item.getAc() + " AC");
        }

        itemValueText.setText(valueOf(item.getItemValue()));

    }
}

