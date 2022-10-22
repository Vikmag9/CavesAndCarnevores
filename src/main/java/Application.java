import Model.Character;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Application extends javafx.application.Application {

    /**
     * Starts the program displaying the main screen.
     * sets the base screen to the corresponding fxml-file, which contains a border pane that is loaded with other fxml-files in the screen controller.
     * @throws IOException
     */
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        Label l = new Label("Här står saker:, JavaFX version:" + javafxVersion + ", Java på version" + javaVersion + ".");


        Parent root = FXMLLoader.load(getClass().getResource("BaseScreen.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Caves and Carnivores");


        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        primaryStage.setMaximized(true);


    }

    /**
     * Main method - Starts the program.
     * Calls on the start method, which deals with the scene.
     * @param args for running the main method according to Java.
     */
    public static void main(String[] args) {
        launch();
    }

}