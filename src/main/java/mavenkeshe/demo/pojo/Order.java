package mavenkeshe.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private int goodId;
    private int userId;
    private int amount;
    private double totalPrice;
    private double goodPrice;
}
