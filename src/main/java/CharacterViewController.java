import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CharacterViewController implements Initializable {
    @FXML private TextArea actionsTextArea;
    @FXML private TextArea reactionsTextArea;
    @FXML private TextArea bonusActionsTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setActionsTextArea();
        setReactionsTextArea();
        setBonusActionsTextArea();
    }

    private void setActionsTextArea() {
        String actions = """
                - Attack
                - Dash
                - Disengage
                - Dodge
                - Help
                - Hide
                - Search
                - Use an Object
                - Grapple
                - Shove
                - Cast a Spell
                - Ready An Action
                - Use a Class Feature""";

        actionsTextArea.setText(actions);
    }

    private void setReactionsTextArea() {
        String reactions = """
                - Opporty Attack
                - Perform a readied action
                - Cast a spell
                """;

        reactionsTextArea.setText(reactions);
    }

    private void setBonusActionsTextArea() {
        String bonusActions = """
                - Offhand Attack
                - Cast a spell
                - Use a Class Feature
                """;

        bonusActionsTextArea.setText(bonusActions);
    }


}
