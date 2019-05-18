package wsi.various;

import wsi.fx1.model.Voter;

public class LombokExample {


    public static void main(String[] args) {
        Voter v = new Voter("a", "a", "a", 13);
        Voter x = new Voter("a", "a", "a", 12);
        System.out.println(v.equals(x));
        System.out.println(v);
        System.out.println(v.getPesel());

        Voter m = Voter.builder().age(12).name("Xiaoping").build();
        System.out.println(m);
    }

}
