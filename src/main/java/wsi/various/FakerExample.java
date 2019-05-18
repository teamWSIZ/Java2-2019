package wsi.various;

import com.github.javafaker.Faker;

import java.util.Locale;
//full docu: https://github.com/DiUS/java-faker/blob/master/README.md
//intro: https://www.baeldung.com/java-faker

public class FakerExample {
    public static void main(String[] args) {
        Faker f = new Faker(new Locale("en-US")); //pl, en-UK, ru, ...
        for (int i = 0; i < 10; i++) {
            System.out.println(f.address().city() + ", " + f.address().state());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(f.avatar().image());
        }
        System.out.println(f.idNumber().valid()); //US
        System.out.println(f.internet().ipV4Address());
        System.out.println(f.leagueOfLegends().summonerSpell());
    }
}
