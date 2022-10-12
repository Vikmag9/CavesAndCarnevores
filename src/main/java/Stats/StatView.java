package Stats;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class StatView {
    @FXML private Label StatView1Big;
    @FXML private Label StatView2Big;
    @FXML private Label StatView3Big;
    @FXML private Label StatView4Big;
    @FXML private Label StatView5Big;
    @FXML private Label StatView6Big;
    @FXML private Label StatView1Small;
    @FXML private Label StatView2Small;
    @FXML private Label StatView3Small;
    @FXML private Label StatView4Small;
    @FXML private Label StatView5Small;
    @FXML private Label StatView6Small;

    @FXML
    public void updateStatView(ArrayList<Integer> stats){
        StatView1Big.setText(stats.get(0).toString());
    }
}
