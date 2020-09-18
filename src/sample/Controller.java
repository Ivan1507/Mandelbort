package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
public class Controller {
    @FXML
    private Button bt;
    @FXML
    public void CLick(ActionEvent ev){
        bt.setText("Endless");
    }
}
