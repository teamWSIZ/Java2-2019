package wsi.fx1;

import com.google.common.base.Splitter;

import java.util.List;

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
        return null;
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

    }
}
