import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class FxmlHelper {
    private Pane view;

    public Pane loadFxml(String filename) {
        try {
            URL fileUrl = SceneController.class.getResource(filename + ".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view = new FXMLLoader().load(fileUrl);
        } catch (IOException e) {
            System.out.println("Error loading FXML file: " + filename);
        }
        return view;
    }
}
