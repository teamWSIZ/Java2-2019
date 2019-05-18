package wsi.fx1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    public String firstName;
    public String lastName;
    public String job;
    //dodać "city", "province"
}