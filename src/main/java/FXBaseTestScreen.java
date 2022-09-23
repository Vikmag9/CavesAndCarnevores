import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

public class FXBaseTestScreen extends Application {

    public void start(Stage stage) throws IOException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Här står saker:, JavaFX version:" + javafxVersion + ", Java på version" + javaVersion + ".");



        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartScreen.fxml")));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);


    }


    public static void main(String[] args) {
        launch();;
    }


}
