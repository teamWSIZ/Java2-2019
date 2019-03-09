package wsi.fx1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML Button b1;
    @FXML TextField tf1;

    public void kliked() {
        System.out.println("the button has been cliked; in text field:" + tf1.getText());
    }
}
