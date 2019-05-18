package wsi.fx1.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Voter {
    String pesel;
    String voterID;
    String name;
    Integer age;    //int
}
