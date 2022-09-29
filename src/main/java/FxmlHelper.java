import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class FxmlHelper {
    private Pane view;

    public Pane loadFxml(String filename) {
        try {
            URL fileUrl = SceneController.class.getResource("testing.fxml" );
            //"C:" + "\u00c5" + "Users" + "\u00c5" + "arash" + "\u00c5" +"IdeaProjects" +"\u00c5" + "CavesAndCarnevores" +"\u00c5" +"src" +"\u00c5"+ "main" + "\u00c5" + "resources" + "\u00c5
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            new FXMLLoader();
            view = FXMLLoader.load(fileUrl);
        } catch (IOException e) {
            System.out.println("Error loading FXML file: " + filename + ". Error: " + e);
        }
        return view;
    }
}
