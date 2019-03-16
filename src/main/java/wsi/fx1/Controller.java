package wsi.fx1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class Controller {
    @FXML Button b2;
    @FXML TextField tf1;
    @FXML TextField liczbaA;
    @FXML TextField liczbaB;
    @FXML Stage stage;

    public void kliked() {
        System.out.println("naciśnięto przycisk:" + tf1.getText());
    }

    public void clear() {
        tf1.setText("");
    }

    public void rrrr() {
        System.out.println("rrrrrrrrrr");
        tf1.setText("rrrrrrr");
    }

    public void addNumbers() {
        double a = parseDouble(liczbaA.getText());
        double b = parseDouble(liczbaB.getText());
        double w = a + b;
        tf1.setText("" + w);
    }

    public void ggg() {
        String x = tf1.getText();
        double d = parseDouble(x);
        System.out.println(d * d);
    }

    private double parseDouble(String text) {

        double x = 0;
        try {
            x = Double.parseDouble(text);
        } catch (NumberFormatException e) {
            displayWrongInputDialog(text);
        }

        return x;
    }

    // https://code.makery.ch/blog/javafx-dialogs-official/
    private void displayWrongInputDialog(String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Złe dane wejściwe");
        alert.setHeaderText("Złe dane wejściowe");
        alert.setContentText("Tego napisu [" + text + "] nie da się zamienić na liczbę");

        alert.showAndWait();
    }

    public void openFromFile() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Otwórz plik...");
        File f = chooser.showOpenDialog(stage);
        if (f!=null) {
            //ładowanie z pliku...
        }
    }

}
