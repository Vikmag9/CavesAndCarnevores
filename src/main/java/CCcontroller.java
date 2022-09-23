import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.*;


public class CCcontroller {



    public WizardController wizardController = new WizardController(this);
    public StartScreenController startScreenController = new StartScreenController(this);

    private Wizard wizard = new Wizard(wizardController);
    private StartScreen startScreen = new StartScreen(startScreenController);
}
