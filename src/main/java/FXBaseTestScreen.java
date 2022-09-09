import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class FXBaseTestScreen extends Application {

    public void start(Stage stage) throws IOException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        Label l = new Label("Här står saker:, JavaFX version:" + javafxVersion + ", Java på version" + javaVersion + ".");

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        /* ResourceBundle bundle = java.util.ResourceBundle.getBundle("imat/resources/iMat");

        Parent root = FXMLLoader.load(getClass().getResource("i_mat.fxml"), bundle);
        Scene scene = new Scene(root, 0, 0);
        stage.setTitle(bundle.getString("application.name"));
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
        stage.setResizable(false); */

        //Scene scene = new Scene(new StackPane(l), 640, 480);
        //stage.setScene(scene);
        //stage.show();
    }


    public static void main(String[] args) {
        launch();
    }


}
