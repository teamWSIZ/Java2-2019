package wsi.fx1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    Integer id;
    String brand;
    String model;

    @Override
    public String toString() {
        return brand + " -> " + model;
    }
}
