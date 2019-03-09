package wsi.fx1;

import com.google.common.base.Splitter;

import java.util.List;

public class A {
    public static void main(String[] args) {
        String input = "1,3, 5,      111,";

        //normalne splittowanie stringów
        String[] inputz = input.split(",");
        for(String s : inputz) {
            System.out.println("[" + s + "]");
        }

        //użycie guavy

        List<String> ll = Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .splitToList(input);
        for(String s : ll) {
            System.out.println("{" + s + "}");
        }

    }
}
