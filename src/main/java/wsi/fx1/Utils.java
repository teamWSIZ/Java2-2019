package wsi.fx1;

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;
import static java.util.stream.Collectors.toList;

public class Utils {

    public static List<String> parseListFromCsv(String csv) {
        List<String> res = Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .splitToList(csv);
        return res;
    }

    /**
     * Funkcja ma zamienić napis na listę liczb całkowitych; jeśli tego nie da się zrobić
     * (np. dla "11,xx,12" to ma wyrzucić NumberFormatException )
     *
     * Funkcja wykorzystuje "Integer.valueOf("12")"
     */
    public static List<Integer> parseIntegersFromCsv(String csv) {
        List<String> strings = parseListFromCsv(csv);
        //mamy już listę stringów
        List<Integer> wynik = new ArrayList<>();
        for(String s : strings) {
            wynik.add(valueOf(s));
        }
        return wynik;
    }

    //też możliwy sposób pisania (tzw. stream-y)
    public static List<Integer> gg(String csv) {
        return parseListFromCsv(csv).stream()
                .map(Integer::valueOf)
                .collect(toList());
    }


    public static void main(String[] args) {
        String input = "1,3, 5,      111,,,";

        //normalne splittowanie stringów
        String[] inputz = input.split(",");
        for(String s : inputz) {
            System.out.println("[" + s + "]");
        }

        System.out.println("-------------------");

        //użycie guavy
//        Utils xx = new Utils();

        List<String> lista = Utils.parseListFromCsv(input);


        for(String s : lista) {
            System.out.println("{" + s + "}");
        }

        System.out.println(parseIntegersFromCsv("1,3,5,7"));

    }
}
