import Model.Character;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Application extends javafx.application.Application {
    Character character;

    public void start(Stage stage) throws IOException, ClassNotFoundException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        Label l = new Label("Här står saker:, JavaFX version:" + javafxVersion + ", Java på version" + javaVersion + ".");


        SceneController sceneController = new SceneController();

        Parent root = FXMLLoader.load(getClass().getResource("BaseScreen.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Caves and Carnivores");


        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        primaryStage.setMaximized(true);
        //sceneController.prepareComboBoxes();


        //sceneController.openStartScreen();

    }


    public static void main(String[] args) {
        launch();
    }

}