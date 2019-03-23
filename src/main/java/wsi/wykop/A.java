package wsi.wykop;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class A {
    public static void main(String[] args) {
        Multiset<Integer> s = HashMultiset.create();
        s.add(5);
        s.add(5);
        s.add(2);
        System.out.println(s);
        s.remove(5);
        System.out.println(s);
    }
}
