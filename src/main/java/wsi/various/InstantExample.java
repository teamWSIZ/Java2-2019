package wsi.various;

import java.time.Instant;
import java.util.Date;

public class InstantExample {
    public static void main(String[] args) {
        double a = 1.11;
        int g = (int) a;
        System.out.println(g);


        long czas = Instant.now().toEpochMilli();

        System.out.println(czas);

    }
}
