package wsi.fx1;

import com.github.javafaker.Faker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import wsi.fx1.model.Car;
import wsi.fx1.model.Person;

import java.time.Instant;
import java.time.ZoneId;
import java.util.*;

import static java.util.Arrays.asList;



public class Controller {
    public BorderPane mainpane;
    @FXML TableView tv;
    @FXML ComboBox kombo;
    @FXML DatePicker piker;
    @FXML CheckBox premium;
    @FXML Button b2;
    @FXML TextField tf1;
    @FXML TextField liczbaA;
    @FXML TextField liczbaB;

    @FXML TextField csvInput;
    @FXML TextField page;

    @FXML TextField csvInput2;
    @FXML Label bot;

    @FXML Stage stage;


    @FXML
    public void initialize() {
        System.out.println(stage);
        System.out.println("starting");

//        mainpane.setBackground(Background.EMPTY);
//        Image image = new Image(getClass().getClassLoader().getResource("ac.jpg"));
//        String style = "-fx-background-color: rgba(255, 255, 150, 0.5);";
//        String style = "-fx-background-image: url('file:ac.jpg');";
//        mainpane.setStyle(style);

        fillCombo();
        initTable();
    }

    private void initTable() {
        TableColumn<String, Person> c1 = new TableColumn<>("First name");
        TableColumn<String, Person> c2 = new TableColumn<>("Last name");
        TableColumn<String, Person> c3 = new TableColumn<>("Job");
        c1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        c2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        c3.setCellValueFactory(new PropertyValueFactory<>("job"));
        tv.getColumns().addAll(asList(c1,c2,c3));

        Faker f = new Faker(new Locale("en-US")); //pl, en-UK, ru, ...
        for (int i = 0; i < 10; i++) {
            tv.getItems().add(new Person(f.name().firstName(), f.name().lastName(), f.job().title()));
        }
    }

    private void fillCombo() {
        List<Car> cars = asList(
                new Car(1,"Ferrari","458"),
                new Car(2,"BMW","M3"),
                new Car(3,"Audi", "RS7"),
                new Car(4,"Honda", "TypeR"),
                new Car(5,"SsangYong", "Korando")
                );
        Collections.sort(cars, Comparator.comparing(car -> car.brand));
        kombo.getItems().addAll(cars);
        kombo.getSelectionModel().select(0);
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
        alert.setHeaderText("Wynik");
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
        alert.showAndWait();

    }

    public void action2(ActionEvent actionEvent) {

        System.out.println("action 2");
        System.out.println("action 2");
    }

    public void checked(ActionEvent actionEvent) {
        System.out.println("checkbox checked; state:" + premium.isSelected());
    }

    public void rezerwuj(ActionEvent actionEvent) {
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        long epoch = piker.getValue().atStartOfDay(zoneId).toEpochSecond();
        Instant ii = Instant.ofEpochSecond(epoch);
        displayResultDialog(ii.toString());
    }

    public void wybierzSamochod(ActionEvent actionEvent) {
        System.out.println(kombo.getSelectionModel().getSelectedItem());
        displayResultDialog("Wybrano: " + kombo.getSelectionModel().getSelectedItem());
    }
}
