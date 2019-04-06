package wsi.various;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Set;
import java.util.TreeSet;

public class A {
    static void testSet(Set<String> r) {
        System.out.println(r.contains("USD"));
        r.remove("USD");
        System.out.println(r.contains("USD"));
    }

    public static void main(String[] args) {
        /**
         * Set: cel struktury: zbieranie elementów, unikalnych,
         * szybkie sprawdzanie czy element istnieje, i szybkie usuwanie.
         *
         * (Szybkie tzn. log(N); tzn. log_2(N), tzn. 20 operacji na 1_000_000 elementów
         * HashSet O(1)... const ... ~10 operacji ..
         * TreeSet O(logN) ... 20 operacji na 1_000_000
         */

        //todo: find the fast collection for java...

//        Set<String> r = new HashSet<>();
        TreeSet<String> r = new TreeSet<>();
        r.add("PLN");
        r.add("PLN");
        r.add("PLN");
        r.add("USD");
        r.add("SGD");
        r.add("TRY");
        r.add("CNY");
        System.out.println(r);
        testSet(r);
        System.out.println("------");


        /**
         * To jest struktura z guava,
         * Zbiera jak w Set, ale zlicza duplikaty
         */

        Multiset<Integer> s = HashMultiset.create();
        s.add(5);
        s.add(5);
        s.add(2);
        System.out.println(s);
        s.remove(5);
        System.out.println(s);
    }
}
