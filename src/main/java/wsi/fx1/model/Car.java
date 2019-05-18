package wsi.fx1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    public Integer id;
    public String brand;
    public String model;

    @Override
    public String toString() {
        return brand + " -> " + model;
    }
}
