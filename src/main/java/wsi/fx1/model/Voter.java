package wsi.fx1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voter {
    String pesel;
    String voterID;
    String name;
    Integer age;    //int

    public static void main(String[] args) {
        Voter v = new Voter("a", "a", "a", 13);
        Voter x = new Voter("a", "a", "a", 12);
        System.out.println(v.equals(x));
        System.out.println(v);
    }
}
