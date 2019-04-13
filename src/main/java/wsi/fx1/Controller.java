package wsi.fx1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.Date;
import java.util.List;


public class Controller {
    @FXML Button b2;
    @FXML TextField tf1;
    @FXML TextField liczbaA;
    @FXML TextField liczbaB;

    @FXML TextField csvInput;
    @FXML TextField page;


    @FXML TextField csvInput2;
    @FXML Label bot;


    @FXML
    public void initialize() {
        bot.setText("Current time " + (new Date()));
        System.out.println("starting");
    }


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

    private void displayResultDialog(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wynik");
        alert.setHeaderText("Wynik obliczń");
        alert.setContentText(text);
        alert.showAndWait();
    }

    int computeSum(List<Integer> w) {
        int sum = 0;
        for(int i : w) sum += i;
        return sum;
    }

    int[] maxMin(List<Integer> w) {
        //znaleźć największą i najmniejszą
        int mi = w.get(0);
        int mx = mi;
        for(int i : w) {
            if (i>mx) mx = i;
            if (i<mi) mi = i;
        }
        return new int[]{mi, mx};

    }

    int findChapter(List<Integer> chapters, int page) {
        //Zadanie: w csv podana jest tablica liczb: długości rozdziałów książki,
        // oraz dodatkowo podana jest liczba "str", określająca na której stronie książki
        // znajdujemy się obecnie; trzeba obliczyć któremu rozdziałowi odpowiada ta strona
        // książki
        //
        // przykład [5,8,3,4,4], str=15 --> wynik = 3  (trzeci rozdział zaczyna się na str 13)
        //
        int sum = 0;
        for (int i = 0; i < chapters.size(); i++) {
            int nsum = sum + chapters.get(i);
            if (nsum>= page) return i+1;
            sum = nsum;
        }
        return -1;  //should never happen
    }

    int findMatchingRods(List<Integer> rods) {
        //Zadanie: dostajemy listę długości prętów (każdy między 1 i 10).
        // Spawacz ma połączyć pręty, odpowiednio po dwa, tak by długość
        // zespawanego pręta wynosiła 10; np. może połączyć 3 z 7, ale nie 4 z 7,
        // ani 3 z 3 z 4 (mogą być tylko dwa pręty na raz).
        // Obliczyć ile ostatecznie prętów długości 10 uda się zespawać.
        // Przykład: [1,4,4,6,8,9] --> 2 (połączenia 1-9 oraz 4-6)

        //rozwiązanie:....
        //zał: długości nie są większe niż 10;
        int[] cnt = new int[11];
        for(int r : rods) cnt[r]++;

        int result = cnt[10];
        for (int i = 1; i < 5; i++) {
            result += Math.min(cnt[i], cnt[10-i]);
        }
        result += cnt[5]/2;

        return result;
    }


    public void liczSume() {
        String s = csvInput.getText();

        /// zamienić na listę intów (wykorzystać funkcję z Utils)
        List<Integer> w = Utils.parseIntegersFromCsv(s);
//        int pageInt = Integer.parseInt(page.getText());

        /// pokazać okno dialogowe z wyliczoną sumą..
        displayResultDialog("Rozdział:" + findMatchingRods(w));
    }

    static boolean isPossible(int n, int m) {
        return true;
    }

    public void sprawdzLiczby() {
        String s = csvInput2.getText();
        List<Integer> w = Utils.parseIntegersFromCsv(s);

        boolean wynik = isPossible(w.get(0), w.get(1));
        displayResultDialog("Wynik:" + (wynik?"tak":"nie"));
    }


    public void sayIt(KeyEvent keyEvent) {
        //stub
    }

    public void myOpenFile(ActionEvent actionEvent) {
        //stub
    }

    public void showAboutDialog(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        ImageView view = new ImageView(new Image("hacked.jpg"));
        view.setFitHeight(225);
        view.setFitWidth(540);
        alert.setGraphic(view);
        //https://code.makery.ch/blog/javafx-dialogs-official/

        alert.setTitle("About this app");
//        alert.setHeaderText("Rockets are heading to your location; take cover now!");
//        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(new Image("missile.png")); // To add an icon
        alert.showAndWait();

    }

    public void action2(ActionEvent actionEvent) {

        System.out.println("action 2");
        System.out.println("action 2");
    }
}
