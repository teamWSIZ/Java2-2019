package wsi.fx1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;


public class Controller {
    @FXML Button b2;
    @FXML TextField tf1;
    @FXML TextField liczbaA;
    @FXML TextField liczbaB;

    @FXML TextField csvInput;
    @FXML TextField page;



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
        return -1;
    }


    public void liczSume() {
        String s = csvInput.getText();

        /// zamienić na listę intów (wykorzystać funkcję z Utils)
        List<Integer> w = Utils.parseIntegersFromCsv(s);
        int pageInt = Integer.parseInt(page.getText());

        /// pokazać okno dialogowe z wyliczoną sumą..
        displayResultDialog("Rozdział:" + findChapter(w, pageInt));

    }
}
